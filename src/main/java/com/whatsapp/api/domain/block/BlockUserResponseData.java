package com.whatsapp.api.domain.block;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BlockUserResponseData(
        @JsonProperty("added_users") List<BlockUserResult> addedUsers,
        @JsonProperty("removed_users") List<BlockUserResult> removedUsers
) {
}
