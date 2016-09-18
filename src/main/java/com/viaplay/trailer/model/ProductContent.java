package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductContent {

    @JsonProperty
    ImdbInfo imdb;

    public ProductContent() {
    }

    public ImdbInfo getImdb() {
        return imdb;
    }
}
