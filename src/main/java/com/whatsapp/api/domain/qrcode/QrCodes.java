package com.whatsapp.api.domain.qrcode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record QrCodes(
        @JsonProperty("data") List<QrCode> data
) {
}
