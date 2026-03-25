package com.whatsapp.api.domain.billing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExtendedCredit(
        @JsonProperty("id") String id,
        @JsonProperty("legal_entity_name") String legalEntityName,
        @JsonProperty("allocated_amount") Object allocatedAmount,
        @JsonProperty("max_balance") Object maxBalance
) {
}
