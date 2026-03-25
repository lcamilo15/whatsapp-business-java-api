package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Flow(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("categories") List<String> categories,
        @JsonProperty("status") String status,
        @JsonProperty("validation_errors") List<FlowValidationError> validationErrors,
        @JsonProperty("json_version") String jsonVersion,
        @JsonProperty("data_api_version") String dataApiVersion,
        @JsonProperty("data_channel_uri") String dataChannelUri,
        @JsonProperty("preview") FlowPreview preview,
        @JsonProperty("health_status") FlowHealthStatus healthStatus,
        @JsonProperty("whatsapp_business_account") FlowWaba whatsappBusinessAccount,
        @JsonProperty("application") FlowApplication application
) {
}
