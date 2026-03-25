package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowValidationError(
        @JsonProperty("error") String error,
        @JsonProperty("error_type") String errorType,
        @JsonProperty("message") String message,
        @JsonProperty("line_start") Integer lineStart,
        @JsonProperty("line_end") Integer lineEnd,
        @JsonProperty("column_start") Integer columnStart,
        @JsonProperty("column_end") Integer columnEnd
) {
}
