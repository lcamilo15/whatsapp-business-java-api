package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowHealthEntity(
        @JsonProperty("entity_type") String entityType,
        @JsonProperty("id") String id,
        @JsonProperty("can_send_message") String canSendMessage,
        @JsonProperty("errors") List<FlowHealthError> errors
) {
}
