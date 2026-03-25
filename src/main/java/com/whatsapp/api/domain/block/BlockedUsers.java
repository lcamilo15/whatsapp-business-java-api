package com.whatsapp.api.domain.block;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.response.Paging;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BlockedUsers(
        @JsonProperty("data") List<BlockedUser> data,
        @JsonProperty("paging") Paging paging
) {
}
