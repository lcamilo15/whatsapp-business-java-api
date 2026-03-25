package com.whatsapp.api.domain.waba;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.response.Paging;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record WhatsappBusinessAccounts(
        @JsonProperty("data") List<WhatsappBusinessAccount> data,
        @JsonProperty("paging") Paging paging
) {
}
