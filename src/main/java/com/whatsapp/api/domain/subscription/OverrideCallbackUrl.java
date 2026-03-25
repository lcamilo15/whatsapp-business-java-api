package com.whatsapp.api.domain.subscription;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OverrideCallbackUrl {

    @JsonProperty("override_callback_uri")
    private String overrideCallbackUri;

    @JsonProperty("verify_token")
    private String verifyToken;

    public String getOverrideCallbackUri() {
        return overrideCallbackUri;
    }

    public OverrideCallbackUrl setOverrideCallbackUri(String overrideCallbackUri) {
        this.overrideCallbackUri = overrideCallbackUri;
        return this;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public OverrideCallbackUrl setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
        return this;
    }
}
