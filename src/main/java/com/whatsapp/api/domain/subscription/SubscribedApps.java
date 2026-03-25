package com.whatsapp.api.domain.subscription;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubscribedApps(
        @JsonProperty("data") List<SubscribedApp> data
) {
}
