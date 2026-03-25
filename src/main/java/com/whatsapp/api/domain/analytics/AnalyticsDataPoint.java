package com.whatsapp.api.domain.analytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AnalyticsDataPoint(
        @JsonProperty("start") Long start,
        @JsonProperty("end") Long end,
        @JsonProperty("sent") Long sent,
        @JsonProperty("delivered") Long delivered
) {
}
