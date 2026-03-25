package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @JsonProperty("status")
    private String status;

    @JsonProperty("items")
    private List<OrderItem> items;

    @JsonProperty("subtotal")
    private OrderAmount subtotal;

    @JsonProperty("tax")
    private OrderAmount tax;

    @JsonProperty("shipping")
    private OrderAmount shipping;

    @JsonProperty("discount")
    private OrderDiscount discount;

    @JsonProperty("catalog_id")
    private String catalogId;

    @JsonProperty("expiration")
    private OrderExpiration expiration;

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Order setItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    public Order addItem(OrderItem item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        return this;
    }

    public OrderAmount getSubtotal() {
        return subtotal;
    }

    public Order setSubtotal(OrderAmount subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public OrderAmount getTax() {
        return tax;
    }

    public Order setTax(OrderAmount tax) {
        this.tax = tax;
        return this;
    }

    public OrderAmount getShipping() {
        return shipping;
    }

    public Order setShipping(OrderAmount shipping) {
        this.shipping = shipping;
        return this;
    }

    public OrderDiscount getDiscount() {
        return discount;
    }

    public Order setDiscount(OrderDiscount discount) {
        this.discount = discount;
        return this;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public Order setCatalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    public OrderExpiration getExpiration() {
        return expiration;
    }

    public Order setExpiration(OrderExpiration expiration) {
        this.expiration = expiration;
        return this;
    }
}
