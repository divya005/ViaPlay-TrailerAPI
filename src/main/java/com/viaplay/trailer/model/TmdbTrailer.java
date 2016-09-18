package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbTrailer {

    @JsonProperty("youtube")
    List<YouTubeTrailer> youTubeTrailers;

    public TmdbTrailer() {
    }

    public List<YouTubeTrailer> getYouTubeTrailers() {
        return youTubeTrailers;
    }
}
