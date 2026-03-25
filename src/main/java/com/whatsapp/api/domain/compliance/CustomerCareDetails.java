package com.whatsapp.api.domain.compliance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CustomerCareDetails(
        @JsonProperty("email") String email,
        @JsonProperty("landline_number") String landlineNumber,
        @JsonProperty("mobile_number") String mobileNumber
) {
}
