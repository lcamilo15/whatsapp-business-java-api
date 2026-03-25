package com.whatsapp.api.domain.subscription;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubscribedApp(
        @JsonProperty("whatsapp_business_api_data") AppData whatsappBusinessApiData,
        @JsonProperty("override_callback_uri") String overrideCallbackUri
) {
}
