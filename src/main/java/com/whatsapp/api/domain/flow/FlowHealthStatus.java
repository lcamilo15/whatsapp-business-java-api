package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowHealthStatus(
        @JsonProperty("can_send_message") String canSendMessage,
        @JsonProperty("entities") List<FlowHealthEntity> entities
) {
}
