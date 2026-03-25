package com.whatsapp.api.domain.flow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MigratedFlow(
        @JsonProperty("source_id") String sourceId,
        @JsonProperty("source_name") String sourceName,
        @JsonProperty("migrated_id") String migratedId
) {
}
