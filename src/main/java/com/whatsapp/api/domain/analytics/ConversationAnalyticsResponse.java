package com.whatsapp.api.domain.analytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConversationAnalyticsResponse(
        @JsonProperty("conversation_analytics") ConversationAnalytics conversationAnalytics,
        @JsonProperty("id") String id
) {
}
