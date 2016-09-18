package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeTrailer {

    @JsonProperty
    String name;

    @JsonProperty
    String source;

    public YouTubeTrailer() {
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }
}
