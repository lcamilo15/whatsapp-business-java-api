package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Contact.
 *
 * @param profile   The {@link Profile} object.
 * @param waId      The WhatsApp ID of the customer. You can send messages using this wa_id.
 * @param bsuId     Business-Scoped User ID (BSUID). New in 2026, privacy-preserving identifier for the customer.
 * @param username  The customer's WhatsApp username. Available when username visibility is enabled (June 2026).
 * @param userId    The user_id field added by Meta to the webhook Contact payload.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Contact(

        @JsonProperty("profile") Profile profile,

        @JsonProperty("name") Name name,

        @JsonProperty("phones") List<Phone> phones,

        @JsonProperty("wa_id") String waId,

        @JsonProperty("bsu_id") String bsuId,

        @JsonProperty("username") String username,

        @JsonProperty("user_id") String userId) {

}
