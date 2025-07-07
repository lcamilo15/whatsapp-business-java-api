package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a request to mark a message as read,
 * optionally displaying a typing indicator to the WhatsApp user.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/mark-message-as-read">API documentation - Mark Message as Read</a>
 */
public class ReadMessage {

	@JsonProperty("messaging_product")
	private final String messagingProduct = "whatsapp";

	@JsonProperty("status")
	private String status = "read";

	@JsonProperty("message_id")
	private String messageId;

	@JsonProperty("typing_indicator")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private TypingIndicator typingIndicator;

	public ReadMessage(String messageId) {
		this.messageId = messageId;
	}

	public ReadMessage(String messageId, TypingIndicator typingIndicator) {
		this.messageId = messageId;
		this.typingIndicator = typingIndicator;
	}

	public String getMessagingProduct() {
		return messagingProduct;
	}

	public String getStatus() {
		return status;
	}

	public String getMessageId() {
		return messageId;
	}

	public TypingIndicator getTypingIndicator() {
		return typingIndicator;
	}

	public void setTypingIndicator(TypingIndicator typingIndicator) {
		this.typingIndicator = typingIndicator;
	}

	/**
	 * Represents the typing indicator object.
	 */
	public static class TypingIndicator {

		@JsonProperty("type")
		private String type;

		public TypingIndicator() {
		}

		public TypingIndicator(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}
}
