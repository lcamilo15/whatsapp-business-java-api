package com.whatsapp.api.domain.compliance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ComplianceInfo(
        @JsonProperty("entity_name") String entityName,
        @JsonProperty("entity_type") String entityType,
        @JsonProperty("is_registered") Boolean isRegistered,
        @JsonProperty("grievance_officer_details") OfficerDetails grievanceOfficerDetails,
        @JsonProperty("customer_care_details") CustomerCareDetails customerCareDetails,
        @JsonProperty("messaging_product") String messagingProduct
) {
}
