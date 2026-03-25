package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDiscount {

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("description")
    private String description;

    @JsonProperty("discount_program_name")
    private String discountProgramName;

    public Integer getValue() {
        return value;
    }

    public OrderDiscount setValue(Integer value) {
        this.value = value;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public OrderDiscount setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderDiscount setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDiscountProgramName() {
        return discountProgramName;
    }

    public OrderDiscount setDiscountProgramName(String discountProgramName) {
        this.discountProgramName = discountProgramName;
        return this;
    }
}
