package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MigrateFlowsRequest {

    @JsonProperty("source_waba_id")
    private String sourceWabaId;

    @JsonProperty("source_flow_names")
    private List<String> sourceFlowNames;

    public String getSourceWabaId() {
        return sourceWabaId;
    }

    public MigrateFlowsRequest setSourceWabaId(String sourceWabaId) {
        this.sourceWabaId = sourceWabaId;
        return this;
    }

    public List<String> getSourceFlowNames() {
        return sourceFlowNames;
    }

    public MigrateFlowsRequest setSourceFlowNames(List<String> sourceFlowNames) {
        this.sourceFlowNames = sourceFlowNames;
        return this;
    }
}
