package com.whatsapp.api.domain.flow.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FlowStatus {
    DRAFT("DRAFT"),
    PUBLISHED("PUBLISHED"),
    DEPRECATED("DEPRECATED"),
    BLOCKED("BLOCKED"),
    THROTTLED("THROTTLED");

    private final String value;

    FlowStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
