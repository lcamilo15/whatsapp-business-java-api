package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MigrateFlowsResponse(
        @JsonProperty("migrated_flows") List<MigratedFlow> migratedFlows,
        @JsonProperty("failed_flows") List<FailedFlow> failedFlows
) {
}
