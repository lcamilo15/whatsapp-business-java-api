package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowParameters {

    @JsonProperty("flow_message_version")
    private String flowMessageVersion;

    @JsonProperty("flow_action")
    private String flowAction;

    @JsonProperty("flow_token")
    private String flowToken;

    @JsonProperty("flow_id")
    private String flowId;

    @JsonProperty("flow_name")
    private String flowName;

    @JsonProperty("flow_cta")
    private String flowCta;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("flow_action_payload")
    private FlowActionPayload flowActionPayload;

    public String getFlowMessageVersion() {
        return flowMessageVersion;
    }

    public FlowParameters setFlowMessageVersion(String flowMessageVersion) {
        this.flowMessageVersion = flowMessageVersion;
        return this;
    }

    public String getFlowAction() {
        return flowAction;
    }

    public FlowParameters setFlowAction(String flowAction) {
        this.flowAction = flowAction;
        return this;
    }

    public String getFlowToken() {
        return flowToken;
    }

    public FlowParameters setFlowToken(String flowToken) {
        this.flowToken = flowToken;
        return this;
    }

    public String getFlowId() {
        return flowId;
    }

    public FlowParameters setFlowId(String flowId) {
        this.flowId = flowId;
        return this;
    }

    public String getFlowName() {
        return flowName;
    }

    public FlowParameters setFlowName(String flowName) {
        this.flowName = flowName;
        return this;
    }

    public String getFlowCta() {
        return flowCta;
    }

    public FlowParameters setFlowCta(String flowCta) {
        this.flowCta = flowCta;
        return this;
    }

    public String getMode() {
        return mode;
    }

    public FlowParameters setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public FlowActionPayload getFlowActionPayload() {
        return flowActionPayload;
    }

    public FlowParameters setFlowActionPayload(FlowActionPayload flowActionPayload) {
        this.flowActionPayload = flowActionPayload;
        return this;
    }
}
