package com.viaplay.trailer.exceptions;

import com.viaplay.trailer.model.StatusCode;

public class ViaplayInvalidResponseException extends BaseException{

    public ViaplayInvalidResponseException(String msg, StatusCode statusCode) {
        super(msg, statusCode);
    }
}
