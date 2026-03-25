package com.whatsapp.api.domain.block;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BlockedUser(
        @JsonProperty("messaging_product") String messagingProduct,
        @JsonProperty("wa_id") String waId
) {
}
