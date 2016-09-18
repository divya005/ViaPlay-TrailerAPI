package com.viaplay.trailer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaplayProduct {

    @JsonProperty("content")
    ProductContent productContent;

    public ViaplayProduct() {
    }

    public ProductContent getProductContent() {
        return productContent;
    }
}
