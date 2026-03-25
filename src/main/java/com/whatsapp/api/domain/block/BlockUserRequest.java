package com.whatsapp.api.domain.block;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockUserRequest {

    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";

    @JsonProperty("block_users")
    private List<BlockUserEntry> blockUsers;

    public String getMessagingProduct() {
        return messagingProduct;
    }

    public List<BlockUserEntry> getBlockUsers() {
        return blockUsers;
    }

    public BlockUserRequest setBlockUsers(List<BlockUserEntry> blockUsers) {
        this.blockUsers = blockUsers;
        return this;
    }

    public BlockUserRequest addBlockUser(BlockUserEntry entry) {
        if (this.blockUsers == null) {
            this.blockUsers = new ArrayList<>();
        }
        this.blockUsers.add(entry);
        return this;
    }
}
