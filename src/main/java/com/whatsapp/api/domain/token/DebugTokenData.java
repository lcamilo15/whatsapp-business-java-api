package com.whatsapp.api.domain.token;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DebugTokenData(
        @JsonProperty("app_id") String appId,
        @JsonProperty("type") String type,
        @JsonProperty("application") String application,
        @JsonProperty("data_access_expires_at") Long dataAccessExpiresAt,
        @JsonProperty("expires_at") Long expiresAt,
        @JsonProperty("is_valid") Boolean isValid,
        @JsonProperty("scopes") List<String> scopes,
        @JsonProperty("granular_scopes") List<Object> granularScopes,
        @JsonProperty("user_id") String userId
) {
}
