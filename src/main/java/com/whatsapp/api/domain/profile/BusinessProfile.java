package com.whatsapp.api.domain.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BusinessProfile(
        @JsonProperty("messaging_product") String messagingProduct,
        @JsonProperty("address") String address,
        @JsonProperty("description") String description,
        @JsonProperty("vertical") String vertical,
        @JsonProperty("about") String about,
        @JsonProperty("email") String email,
        @JsonProperty("websites") List<String> websites,
        @JsonProperty("profile_picture_url") String profilePictureUrl,
        @JsonProperty("id") String id
) {
}
