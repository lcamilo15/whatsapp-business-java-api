package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Audio message.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">Media Object</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AudioMessage extends MediaMessage<AudioMessage> {

    @JsonProperty("voice")
    private Boolean voice;

    /**
     * Gets voice.
     *
     * @return whether this audio message is a voice note
     */
    public Boolean getVoice() {
        return voice;
    }

    /**
     * Sets voice. When set to {@code true}, the audio message will be displayed
     * as a voice note (waveform bubble) instead of an audio file attachment.
     *
     * @param voice true to send as a voice note, false for a regular audio attachment
     * @return this AudioMessage instance for fluent chaining
     */
    public AudioMessage setVoice(Boolean voice) {
        this.voice = voice;
        return this;
    }
}
