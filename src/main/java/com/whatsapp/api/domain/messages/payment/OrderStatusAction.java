package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatusAction {

    @JsonProperty("name")
    private String name;

    @JsonProperty("parameters")
    private OrderStatusParameters parameters;

    public String getName() {
        return name;
    }

    public OrderStatusAction setName(String name) {
        this.name = name;
        return this;
    }

    public OrderStatusParameters getParameters() {
        return parameters;
    }

    public OrderStatusAction setParameters(OrderStatusParameters parameters) {
        this.parameters = parameters;
        return this;
    }
}
