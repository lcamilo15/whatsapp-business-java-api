package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Audio.
 *
 * @param sha256   The checksum of the media.
 * @param mimeType The mime type of the media.
 * @param id       The ID of the media.
 * @param voice    Whether the audio is a voice message.
 * @param url      The URL to download the audio file.
 */
public record Audio(

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("sha256") String sha256,

        @JsonProperty("id") String id,

        @JsonProperty("voice") boolean voice,

        @JsonProperty("url") String url

) {


}
