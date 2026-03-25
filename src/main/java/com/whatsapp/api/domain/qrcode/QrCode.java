package com.whatsapp.api.domain.qrcode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record QrCode(
        @JsonProperty("code") String code,
        @JsonProperty("prefilled_message") String prefilledMessage,
        @JsonProperty("deep_link_url") String deepLinkUrl,
        @JsonProperty("qr_image_url") String qrImageUrl
) {
}
