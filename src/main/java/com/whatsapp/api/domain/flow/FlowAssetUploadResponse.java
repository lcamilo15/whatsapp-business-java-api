package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowAssetUploadResponse(
        @JsonProperty("success") boolean success,
        @JsonProperty("validation_errors") List<FlowValidationError> validationErrors
) {
}
