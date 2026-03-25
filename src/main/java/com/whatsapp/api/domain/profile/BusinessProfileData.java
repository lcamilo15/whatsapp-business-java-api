package com.whatsapp.api.domain.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BusinessProfileData(
        @JsonProperty("business_profile") BusinessProfile businessProfile,
        @JsonProperty("id") String id
) {
}
