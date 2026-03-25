package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatusOrder {

    @JsonProperty("status")
    private String status;

    @JsonProperty("description")
    private String description;

    public String getStatus() {
        return status;
    }

    public OrderStatusOrder setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderStatusOrder setDescription(String description) {
        this.description = description;
        return this;
    }
}
