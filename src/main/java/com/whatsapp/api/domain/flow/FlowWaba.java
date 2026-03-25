package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowWaba(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("timezone_id") String timezoneId,
        @JsonProperty("business_type") String businessType,
        @JsonProperty("message_template_namespace") String messageTemplateNamespace
) {
}
