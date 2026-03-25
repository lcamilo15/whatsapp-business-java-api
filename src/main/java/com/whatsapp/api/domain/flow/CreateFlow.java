package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateFlow {

    @JsonProperty("name")
    private String name;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("clone_flow_id")
    private String cloneFlowId;

    @JsonProperty("endpoint_uri")
    private String endpointUri;

    public String getName() {
        return name;
    }

    public CreateFlow setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getCategories() {
        return categories;
    }

    public CreateFlow setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public String getCloneFlowId() {
        return cloneFlowId;
    }

    public CreateFlow setCloneFlowId(String cloneFlowId) {
        this.cloneFlowId = cloneFlowId;
        return this;
    }

    public String getEndpointUri() {
        return endpointUri;
    }

    public CreateFlow setEndpointUri(String endpointUri) {
        this.endpointUri = endpointUri;
        return this;
    }
}
