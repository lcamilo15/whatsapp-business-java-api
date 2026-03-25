package com.whatsapp.api.domain.analytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConversationDataPoint(
        @JsonProperty("start") Long start,
        @JsonProperty("end") Long end,
        @JsonProperty("conversation") Long conversation,
        @JsonProperty("cost") Double cost,
        @JsonProperty("conversation_type") String conversationType,
        @JsonProperty("conversation_direction") String conversationDirection
) {
}
