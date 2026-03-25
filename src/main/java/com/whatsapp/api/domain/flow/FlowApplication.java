package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowApplication(
        @JsonProperty("link") String link,
        @JsonProperty("name") String name,
        @JsonProperty("id") String id
) {
}
