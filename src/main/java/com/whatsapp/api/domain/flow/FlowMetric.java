package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowMetric(
        @JsonProperty("granularity") String granularity,
        @JsonProperty("name") String name,
        @JsonProperty("data_points") List<FlowMetricDataPoint> dataPoints
) {
}
