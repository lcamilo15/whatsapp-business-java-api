package com.whatsapp.api.domain.analytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Analytics(
        @JsonProperty("phone_numbers") List<String> phoneNumbers,
        @JsonProperty("country_codes") List<String> countryCodes,
        @JsonProperty("granularity") String granularity,
        @JsonProperty("data_points") List<AnalyticsDataPoint> dataPoints
) {
}
