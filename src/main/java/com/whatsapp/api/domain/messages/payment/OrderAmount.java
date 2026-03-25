package com.whatsapp.api.domain.messages.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderAmount {

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("description")
    private String description;

    public Integer getValue() {
        return value;
    }

    public OrderAmount setValue(Integer value) {
        this.value = value;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public OrderAmount setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAmount setDescription(String description) {
        this.description = description;
        return this;
    }
}
