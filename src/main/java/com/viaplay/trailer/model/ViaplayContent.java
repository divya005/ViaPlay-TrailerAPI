package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaplayContent {

    @JsonProperty
    String title;

    @JsonProperty("_embedded")
    ContentEmbedded contentEmbedded;

    public ViaplayContent() {

    }

    public String getTitle() {
        return title;
    }

    public ContentEmbedded getContentEmbedded() {
        return contentEmbedded;
    }
}
