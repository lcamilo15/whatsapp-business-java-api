package com.whatsapp.api.domain.compliance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateComplianceInfo {

    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";

    @JsonProperty("entity_name")
    private String entityName;

    @JsonProperty("entity_type")
    private String entityType;

    @JsonProperty("is_registered")
    private Boolean isRegistered;

    @JsonProperty("grievance_officer_details")
    private CreateOfficerDetails grievanceOfficerDetails;

    @JsonProperty("customer_care_details")
    private CreateCustomerCareDetails customerCareDetails;

    public String getMessagingProduct() {
        return messagingProduct;
    }

    public String getEntityName() {
        return entityName;
    }

    public CreateComplianceInfo setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public String getEntityType() {
        return entityType;
    }

    public CreateComplianceInfo setEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    public Boolean getIsRegistered() {
        return isRegistered;
    }

    public CreateComplianceInfo setIsRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
        return this;
    }

    public CreateOfficerDetails getGrievanceOfficerDetails() {
        return grievanceOfficerDetails;
    }

    public CreateComplianceInfo setGrievanceOfficerDetails(CreateOfficerDetails grievanceOfficerDetails) {
        this.grievanceOfficerDetails = grievanceOfficerDetails;
        return this;
    }

    public CreateCustomerCareDetails getCustomerCareDetails() {
        return customerCareDetails;
    }

    public CreateComplianceInfo setCustomerCareDetails(CreateCustomerCareDetails customerCareDetails) {
        this.customerCareDetails = customerCareDetails;
        return this;
    }
}
