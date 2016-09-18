package com.viaplay.trailer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ServiceConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    private JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

    @JsonProperty
    private String tmdbApiKey;

    public String getTmdbApiKey() {
        return tmdbApiKey;
    }

    @JsonProperty("jerseyClient")
    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClient;
    }
}
