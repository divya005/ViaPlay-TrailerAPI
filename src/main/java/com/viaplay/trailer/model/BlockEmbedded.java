package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockEmbedded {

    @JsonProperty("viaplay:product")
    ViaplayProduct viaplayProduct;

    public BlockEmbedded() {
    }

    public ViaplayProduct getViaplayProduct() {
        return viaplayProduct;
    }
}
