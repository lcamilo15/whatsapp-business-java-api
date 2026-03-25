package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowHealthError(
        @JsonProperty("error_code") Integer errorCode,
        @JsonProperty("error_description") String errorDescription,
        @JsonProperty("possible_solution") String possibleSolution
) {
}
