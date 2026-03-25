package com.whatsapp.api.domain.block;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BlockUserResult(
        @JsonProperty("input") String input,
        @JsonProperty("wa_id") String waId
) {
}
