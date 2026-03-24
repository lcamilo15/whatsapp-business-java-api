package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Image.
 *
 * @param sha256   The checksum of the media.
 * @param mimeType The mime type of the media.
 * @param caption  Added to Webhooks if it has been previously specified.
 * @param id       The ID of the media.
 * @param url      The URL to download the image file.
 */
public record Image(

        @JsonProperty("sha256") String sha256,

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("caption") String caption,

        @JsonProperty("id") String id,

        @JsonProperty("url") String url) {

}