package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowMetricResponse(
        @JsonProperty("id") String id,
        @JsonProperty("metric") FlowMetric metric
) {
}
