package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.response.Paging;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Flows(
        @JsonProperty("data") List<Flow> data,
        @JsonProperty("paging") Paging paging
) {
}
