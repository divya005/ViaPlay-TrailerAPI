package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentEmbedded {

    @JsonProperty("viaplay:blocks")
    List<ViaplayBlock> viaplayBlocks;

    public ContentEmbedded() {
    }

    public List<ViaplayBlock> getViaplayBlocks() {
        return viaplayBlocks;
    }
}
