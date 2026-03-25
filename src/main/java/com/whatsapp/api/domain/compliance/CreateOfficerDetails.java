package com.whatsapp.api.domain.compliance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOfficerDetails {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("landline_number")
    private String landlineNumber;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    public String getName() {
        return name;
    }

    public CreateOfficerDetails setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateOfficerDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public CreateOfficerDetails setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
        return this;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public CreateOfficerDetails setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }
}
