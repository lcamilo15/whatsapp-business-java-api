package com.whatsapp.api.domain.flow.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FlowCategory {
    SIGN_UP("SIGN_UP"),
    SIGN_IN("SIGN_IN"),
    APPOINTMENT_BOOKING("APPOINTMENT_BOOKING"),
    LEAD_GENERATION("LEAD_GENERATION"),
    CONTACT_US("CONTACT_US"),
    CUSTOMER_SUPPORT("CUSTOMER_SUPPORT"),
    SURVEY("SURVEY"),
    OTHER("OTHER");

    private final String value;

    FlowCategory(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
