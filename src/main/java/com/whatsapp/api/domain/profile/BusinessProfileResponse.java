package com.whatsapp.api.domain.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BusinessProfileResponse(
        @JsonProperty("data") List<BusinessProfileData> data
) {
}
