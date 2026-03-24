package com.whatsapp.api.domain.messages.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * WhatsApp Business Platform Bot Type Compliance (2026).
 *
 * As of January 15, 2026, Meta restricted the types of automation allowed on the WhatsApp Business API.
 * The following bot types are the only allowed automation patterns:
 *
 * <ul>
 *   <li><strong>Support Bot</strong>: Automated support workflows (FAQs, ticket creation, etc.)</li>
 *   <li><strong>Booking Bot</strong>: Appointment scheduling and confirmation</li>
 *   <li><strong>Order Bot</strong>: Order placement, tracking, and status updates</li>
 *   <li><strong>Notification Bot</strong>: Transactional notifications (delivery, payment confirmations, alerts)</li>
 * </ul>
 *
 * <strong>Banned Automation:</strong> General-purpose AI chatbots and conversational AI are no longer allowed.
 * Chatbots must have clear, predictable results tied to business messaging use cases (support, orders, scheduling).
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/business-platform/changelog">WhatsApp Business Platform Changelog</a>
 */
public enum BotType {

    /**
     * Support/FAQ automation. Handles customer inquiries, knowledge base responses, support ticket creation.
     * Examples: automated responses to FAQs, routing to human agents, self-service troubleshooting.
     */
    SUPPORT_BOT("support_bot"),

    /**
     * Appointment booking and scheduling automation. Handles availability checks, booking confirmation, reminders.
     * Examples: restaurant reservations, salon appointments, service booking systems.
     */
    BOOKING_BOT("booking_bot"),

    /**
     * E-commerce order automation. Handles order creation, payment collection, status tracking, returns.
     * Examples: product catalog browsing, order placement, shipping updates, returns management.
     */
    ORDER_BOT("order_bot"),

    /**
     * Transactional notification automation. Sends business-initiated messages about customer actions.
     * Examples: delivery notifications, payment confirmations, account alerts, security notifications.
     */
    NOTIFICATION_BOT("notification_bot");

    private final String value;

    BotType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * Check if this bot type is allowed under Meta's 2026 WhatsApp Business Platform policy.
     *
     * @return true if this bot type complies with 2026 policy restrictions; false otherwise.
     *         Currently, all defined BotType values are allowed. This method provides forward compatibility
     *         if Meta adds further restrictions in the future.
     */
    public boolean isAllowedUnderPolicy() {
        return true;
    }
}
