package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImdbInfo {

    @JsonProperty
    String id;

    public ImdbInfo() {
    }

    public String getId() {
        return id;
    }
}
