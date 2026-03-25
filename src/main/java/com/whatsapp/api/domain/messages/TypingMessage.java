package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypingMessage {

    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";

    @JsonProperty("status")
    private String status;

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("typing_indicator")
    private TypingIndicator typingIndicator;

    public String getMessagingProduct() {
        return messagingProduct;
    }

    public String getStatus() {
        return status;
    }

    public TypingMessage setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessageId() {
        return messageId;
    }

    public TypingMessage setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public TypingIndicator getTypingIndicator() {
        return typingIndicator;
    }

    public TypingMessage setTypingIndicator(TypingIndicator typingIndicator) {
        this.typingIndicator = typingIndicator;
        return this;
    }
}
