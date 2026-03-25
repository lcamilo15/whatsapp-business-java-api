package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {

    @JsonProperty("retailer_id")
    private String retailerId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("amount")
    private OrderAmount amount;

    @JsonProperty("sale_amount")
    private OrderAmount saleAmount;

    @JsonProperty("quantity")
    private Integer quantity;

    public String getRetailerId() {
        return retailerId;
    }

    public OrderItem setRetailerId(String retailerId) {
        this.retailerId = retailerId;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderItem setName(String name) {
        this.name = name;
        return this;
    }

    public OrderAmount getAmount() {
        return amount;
    }

    public OrderItem setAmount(OrderAmount amount) {
        this.amount = amount;
        return this;
    }

    public OrderAmount getSaleAmount() {
        return saleAmount;
    }

    public OrderItem setSaleAmount(OrderAmount saleAmount) {
        this.saleAmount = saleAmount;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
