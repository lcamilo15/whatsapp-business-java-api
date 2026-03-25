package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateFlowMetadata {

    @JsonProperty("name")
    private String name;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("endpoint_uri")
    private String endpointUri;

    public String getName() {
        return name;
    }

    public UpdateFlowMetadata setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getCategories() {
        return categories;
    }

    public UpdateFlowMetadata setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public String getEndpointUri() {
        return endpointUri;
    }

    public UpdateFlowMetadata setEndpointUri(String endpointUri) {
        this.endpointUri = endpointUri;
        return this;
    }
}
