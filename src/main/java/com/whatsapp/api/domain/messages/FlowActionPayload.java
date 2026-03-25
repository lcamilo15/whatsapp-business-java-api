package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowActionPayload {

    @JsonProperty("screen")
    private String screen;

    @JsonProperty("data")
    private Map<String, Object> data;

    public String getScreen() {
        return screen;
    }

    public FlowActionPayload setScreen(String screen) {
        this.screen = screen;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public FlowActionPayload setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
}
