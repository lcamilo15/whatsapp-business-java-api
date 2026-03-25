package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterPhone {

    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";

    @JsonProperty("pin")
    private String pin;

    public String getMessagingProduct() {
        return messagingProduct;
    }

    public String getPin() {
        return pin;
    }

    public RegisterPhone setPin(String pin) {
        this.pin = pin;
        return this;
    }
}
