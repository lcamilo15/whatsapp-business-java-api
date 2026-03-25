package com.whatsapp.api.domain.token;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DebugTokenResponse(
        @JsonProperty("data") DebugTokenData data
) {
}
