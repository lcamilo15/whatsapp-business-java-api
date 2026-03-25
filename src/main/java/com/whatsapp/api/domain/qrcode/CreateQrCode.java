package com.whatsapp.api.domain.qrcode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateQrCode {

    @JsonProperty("prefilled_message")
    private String prefilledMessage;

    @JsonProperty("generate_qr_image")
    private String generateQrImage;

    public String getPrefilledMessage() {
        return prefilledMessage;
    }

    public CreateQrCode setPrefilledMessage(String prefilledMessage) {
        this.prefilledMessage = prefilledMessage;
        return this;
    }

    public String getGenerateQrImage() {
        return generateQrImage;
    }

    public CreateQrCode setGenerateQrImage(String generateQrImage) {
        this.generateQrImage = generateQrImage;
        return this;
    }
}
