package com.whatsapp.api.domain.compliance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ComplianceInfoResponse(
        @JsonProperty("data") List<ComplianceInfo> data
) {
}
