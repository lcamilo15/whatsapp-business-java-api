package com.whatsapp.api.domain.qrcode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateQrCode {

    @JsonProperty("prefilled_message")
    private String prefilledMessage;

    @JsonProperty("code")
    private String code;

    public String getPrefilledMessage() {
        return prefilledMessage;
    }

    public UpdateQrCode setPrefilledMessage(String prefilledMessage) {
        this.prefilledMessage = prefilledMessage;
        return this;
    }

    public String getCode() {
        return code;
    }

    public UpdateQrCode setCode(String code) {
        this.code = code;
        return this;
    }
}
