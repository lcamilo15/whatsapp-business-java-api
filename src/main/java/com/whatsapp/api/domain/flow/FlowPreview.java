package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowPreview(
        @JsonProperty("preview_url") String previewUrl,
        @JsonProperty("expires_at") String expiresAt
) {
}
