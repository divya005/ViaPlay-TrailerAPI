package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrailerResult {

    @JsonProperty
    Status status;

    @JsonProperty
    List<Trailer> trailers;

    public TrailerResult(Status status) {
        this.status = status;
    }

    public TrailerResult(Status status, List<Trailer> trailers) {
        this.status = status;
        this.trailers = trailers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }
}
