package com.whatsapp.api.utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Token-bucket message pacing utility for WhatsApp Business API compliance.
 *
 * Provides configurable rate limiting to ensure compliance with Meta's messaging tier limits.
 * As of 2026, WhatsApp enforces the following messaging tiers:
 *
 * <ul>
 *   <li><strong>Standard Tier</strong>: 80 messages per minute (~1.33 per second)</li>
 *   <li><strong>High Tier</strong>: 1,000 messages per minute (~16.67 per second)</li>
 *   <li><strong>Enterprise Tier</strong>: 3,000 messages per minute (~50 per second)</li>
 * </ul>
 *
 * Use {@link #forTier(MessagingTier)} to create a pacing helper for standard tiers,
 * or construct directly with a custom rate: {@code new MessagePacingHelper(50)} for 50 messages per second.
 *
 * <strong>Thread-safe</strong>. All methods are safe to call from multiple threads concurrently.
 *
 * <strong>Example:</strong>
 * <pre>
 * MessagePacingHelper pacing = MessagePacingHelper.forTier(MessagingTier.STANDARD);
 * // Before sending each message:
 * pacing.acquire(); // blocks until a token is available
 * whatsappApi.sendMessage(phoneNumberId, message);
 * </pre>
 *
 * @see MessagingTier
 */
public class MessagePacingHelper {

    private final Semaphore semaphore;
    private final double messagesPerSecond;
    private final ScheduledExecutorService scheduler;
    private final AtomicBoolean shutdown = new AtomicBoolean(false);

    /**
     * Create a message pacing helper with the specified rate.
     *
     * @param messagesPerSecond Target rate in messages per second. Must be > 0.
     *                          Examples: 1.33 (standard tier), 16.67 (high tier), 50 (enterprise tier).
     * @throws IllegalArgumentException if messagesPerSecond <= 0
     */
    public MessagePacingHelper(double messagesPerSecond) {
        if (messagesPerSecond <= 0) {
            throw new IllegalArgumentException("messagesPerSecond must be > 0");
        }
        this.messagesPerSecond = messagesPerSecond;
        this.semaphore = new Semaphore(0);
        this.scheduler = Executors.newScheduledThreadPool(1, r -> {
            Thread t = new Thread(r, "WhatsApp-MessagePacing");
            t.setDaemon(true);
            return t;
        });
        startTokenRefill();
    }

    /**
     * Create a message pacing helper for a standard WhatsApp Business messaging tier.
     *
     * @param tier The messaging tier (STANDARD, HIGH, ENTERPRISE).
     * @return A MessagePacingHelper configured for that tier.
     * @throws NullPointerException if tier is null
     */
    public static MessagePacingHelper forTier(MessagingTier tier) {
        if (tier == null) {
            throw new NullPointerException("tier cannot be null");
        }
        return new MessagePacingHelper(tier.getMessagesPerSecond());
    }

    /**
     * Blocking acquire: blocks until one token is available, then consumes it.
     *
     * Use this before sending a single message to ensure rate limiting is respected.
     *
     * @throws InterruptedException if the calling thread is interrupted while waiting
     */
    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    /**
     * Blocking acquire: blocks until the specified number of tokens are available, then consumes them.
     *
     * @param count The number of tokens to acquire. Must be > 0.
     * @throws IllegalArgumentException if count <= 0
     * @throws InterruptedException if the calling thread is interrupted while waiting
     */
    public void acquire(int count) throws InterruptedException {
        if (count <= 0) {
            throw new IllegalArgumentException("count must be > 0");
        }
        semaphore.acquire(count);
    }

    /**
     * Non-blocking acquire: attempts to acquire one token without blocking.
     *
     * Use this in non-blocking contexts where you want to check if you can send without waiting.
     *
     * @return true if a token was acquired; false if no tokens are currently available.
     */
    public boolean tryAcquire() {
        return semaphore.tryAcquire();
    }

    /**
     * Non-blocking acquire: attempts to acquire the specified number of tokens without blocking.
     *
     * @param count The number of tokens to acquire. Must be > 0.
     * @return true if all tokens were acquired; false if insufficient tokens are available.
     * @throws IllegalArgumentException if count <= 0
     */
    public boolean tryAcquire(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count must be > 0");
        }
        return semaphore.tryAcquire(count);
    }

    /**
     * Gracefully shut down the pacing helper and release resources.
     *
     * Call this when you no longer need the pacing helper (e.g., on application shutdown).
     * After shutdown, acquire() will not block and tokens will not be refilled.
     */
    public void shutdown() {
        if (shutdown.compareAndSet(false, true)) {
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Get the configured rate in messages per second.
     *
     * @return The target rate.
     */
    public double getMessagesPerSecond() {
        return messagesPerSecond;
    }

    /**
     * Start the token refill scheduler.
     *
     * Tokens are refilled at the configured rate. The scheduler runs every 10ms
     * and releases tokens proportionally to the elapsed time.
     */
    private void startTokenRefill() {
        // Calculate tokens per 10ms interval: (messagesPerSecond / 1000) * 10
        double tokensPerInterval = (messagesPerSecond / 100.0);

        scheduler.scheduleAtFixedRate(() -> {
            if (!shutdown.get()) {
                // Release tokens proportionally to the interval, rounding to ensure smooth refill
                int tokensToRelease = Math.max(1, (int) Math.round(tokensPerInterval));
                semaphore.release(tokensToRelease);
            }
        }, 10, 10, TimeUnit.MILLISECONDS);
    }

    /**
     * WhatsApp Business messaging tier definitions.
     *
     * Defines standard messaging rate tiers as per Meta's 2026 WhatsApp Business Platform.
     * Each tier specifies the maximum messages per minute (converted to per-second rates).
     */
    public enum MessagingTier {

        /**
         * Standard tier: 80 messages per minute (~1.33 per second).
         * Suitable for small businesses and testing.
         */
        STANDARD(80.0 / 60.0),

        /**
         * High tier: 1,000 messages per minute (~16.67 per second).
         * Suitable for medium-sized businesses with moderate messaging volume.
         */
        HIGH(1000.0 / 60.0),

        /**
         * Enterprise tier: 3,000 messages per minute (~50 per second).
         * Suitable for large enterprises with high messaging volume.
         */
        ENTERPRISE(3000.0 / 60.0);

        private final double messagesPerSecond;

        MessagingTier(double messagesPerSecond) {
            this.messagesPerSecond = messagesPerSecond;
        }

        /**
         * Get the rate limit for this tier in messages per second.
         *
         * @return The rate in messages per second.
         */
        public double getMessagesPerSecond() {
            return messagesPerSecond;
        }

        /**
         * Get the rate limit for this tier in messages per minute.
         *
         * @return The rate in messages per minute.
         */
        public double getMessagesPerMinute() {
            return messagesPerSecond * 60.0;
        }
    }
}
