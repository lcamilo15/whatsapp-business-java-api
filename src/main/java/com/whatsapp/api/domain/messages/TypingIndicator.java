package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypingIndicator {

    @JsonProperty("type")
    private String type;

    public String getType() {
        return type;
    }

    public TypingIndicator setType(String type) {
        this.type = type;
        return this;
    }
}
