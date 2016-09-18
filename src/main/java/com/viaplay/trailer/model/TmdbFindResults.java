package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbFindResults {

    @JsonProperty("movie_results")
    List<FindMovie> movieResults;

    public TmdbFindResults() {
    }

    public List<FindMovie> getMovieResults() {
        return movieResults;
    }
}
