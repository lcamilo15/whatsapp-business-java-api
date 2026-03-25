package com.whatsapp.api.domain.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateBusinessProfile {

    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("vertical")
    private String vertical;

    @JsonProperty("about")
    private String about;

    @JsonProperty("email")
    private String email;

    @JsonProperty("websites")
    private List<String> websites;

    @JsonProperty("profile_picture_handle")
    private String profilePictureHandle;

    public String getMessagingProduct() {
        return messagingProduct;
    }

    public String getAddress() {
        return address;
    }

    public UpdateBusinessProfile setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UpdateBusinessProfile setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVertical() {
        return vertical;
    }

    public UpdateBusinessProfile setVertical(String vertical) {
        this.vertical = vertical;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public UpdateBusinessProfile setAbout(String about) {
        this.about = about;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateBusinessProfile setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<String> getWebsites() {
        return websites;
    }

    public UpdateBusinessProfile setWebsites(List<String> websites) {
        this.websites = websites;
        return this;
    }

    public String getProfilePictureHandle() {
        return profilePictureHandle;
    }

    public UpdateBusinessProfile setProfilePictureHandle(String profilePictureHandle) {
        this.profilePictureHandle = profilePictureHandle;
        return this;
    }
}
