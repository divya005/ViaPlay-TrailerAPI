package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbMovieResult {

    @JsonProperty
    TmdbTrailer trailers;

    public TmdbMovieResult() {
    }

    public TmdbTrailer getTrailers() {
        return trailers;
    }
}
