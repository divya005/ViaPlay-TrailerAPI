package com.viaplay.trailer.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    @JsonProperty
    StatusCode statusCode;

    @JsonProperty
    String statusreason;

    public Status() {
    }

    public Status(StatusCode statusCode, String statusreason) {
        this.statusCode = statusCode;
        this.statusreason = statusreason;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusreason() {
        return statusreason;
    }

    public void setStatusreason(String statusreason) {
        this.statusreason = statusreason;
    }
}
