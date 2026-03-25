package com.whatsapp.api.domain.compliance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCustomerCareDetails {

    @JsonProperty("email")
    private String email;

    @JsonProperty("landline_number")
    private String landlineNumber;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    public String getEmail() {
        return email;
    }

    public CreateCustomerCareDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public CreateCustomerCareDetails setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
        return this;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public CreateCustomerCareDetails setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }
}
