package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FlowAsset(
        @JsonProperty("name") String name,
        @JsonProperty("asset_type") String assetType,
        @JsonProperty("download_url") String downloadUrl
) {
}
