package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaplayBlock {

    @JsonProperty("_embedded")
    BlockEmbedded blockEmbedded;

    public ViaplayBlock() {
    }

    public BlockEmbedded getBlockEmbedded() {
        return blockEmbedded;
    }
}
