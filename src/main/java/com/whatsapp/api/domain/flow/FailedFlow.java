package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FailedFlow(
        @JsonProperty("source_name") String sourceName,
        @JsonProperty("error_code") String errorCode,
        @JsonProperty("error_message") String errorMessage
) {
}
