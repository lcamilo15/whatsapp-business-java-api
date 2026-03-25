package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderExpiration {

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("description")
    private String description;

    public String getTimestamp() {
        return timestamp;
    }

    public OrderExpiration setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderExpiration setDescription(String description) {
        this.description = description;
        return this;
    }
}
