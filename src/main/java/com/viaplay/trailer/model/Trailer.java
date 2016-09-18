package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trailer {

    @JsonProperty
    String provider;

    @JsonProperty
    String url;

    @JsonProperty
    String name;

    public Trailer() {

    }

    public Trailer(String provider, String url, String name) {
        this.provider = provider;
        this.url = url;
        this.name = name;
    }
}
