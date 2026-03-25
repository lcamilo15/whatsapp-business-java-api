package com.whatsapp.api.domain.billing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExtendedCredits(
        @JsonProperty("data") List<ExtendedCredit> data
) {
}
