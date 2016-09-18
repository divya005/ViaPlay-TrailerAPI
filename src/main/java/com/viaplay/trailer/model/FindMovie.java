package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FindMovie {

    @JsonProperty
    String id;

    public FindMovie() {
    }

    public String getId() {
        return id;
    }
}
