package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Sticker.
 *
 * @param sha256   The checksum of the media.
 * @param mimeType The mime type of the media.
 * @param id       The ID of the media.
 * @param animated Whether the sticker is animated.
 * @param url      The URL to download the sticker file.
 */
public record Sticker(

        @JsonProperty("sha256") String sha256,

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("id") String id,

        @JsonProperty("animated") boolean animated,

        @JsonProperty("url") String url) {

}