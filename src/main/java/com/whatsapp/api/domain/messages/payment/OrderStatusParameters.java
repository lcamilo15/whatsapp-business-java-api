package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatusParameters {

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("order")
    private OrderStatusOrder order;

    public String getReferenceId() {
        return referenceId;
    }

    public OrderStatusParameters setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public OrderStatusOrder getOrder() {
        return order;
    }

    public OrderStatusParameters setOrder(OrderStatusOrder order) {
        this.order = order;
        return this;
    }
}
