package com.whatsapp.api.domain.block;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockUserEntry {

    @JsonProperty("user")
    private String user;

    public String getUser() {
        return user;
    }

    public BlockUserEntry setUser(String user) {
        this.user = user;
        return this;
    }
}
