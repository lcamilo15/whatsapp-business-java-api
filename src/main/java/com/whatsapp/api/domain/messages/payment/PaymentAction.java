package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentAction {

    @JsonProperty("name")
    private String name;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("payment_configuration")
    private String paymentConfiguration;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("total_amount")
    private OrderAmount totalAmount;

    @JsonProperty("order")
    private Order order;

    public String getName() {
        return name;
    }

    public PaymentAction setName(String name) {
        this.name = name;
        return this;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public PaymentAction setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public String getType() {
        return type;
    }

    public PaymentAction setType(String type) {
        this.type = type;
        return this;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public PaymentAction setPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public String getPaymentConfiguration() {
        return paymentConfiguration;
    }

    public PaymentAction setPaymentConfiguration(String paymentConfiguration) {
        this.paymentConfiguration = paymentConfiguration;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public PaymentAction setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public OrderAmount getTotalAmount() {
        return totalAmount;
    }

    public PaymentAction setTotalAmount(OrderAmount totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public PaymentAction setOrder(Order order) {
        this.order = order;
        return this;
    }
}
