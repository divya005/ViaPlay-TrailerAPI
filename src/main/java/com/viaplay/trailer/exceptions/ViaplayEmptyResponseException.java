package com.viaplay.trailer.exceptions;

import com.viaplay.trailer.model.StatusCode;

public class ViaplayEmptyResponseException extends BaseException{

    public ViaplayEmptyResponseException(String msg, StatusCode statusCode) {
        super(msg, statusCode);
    }
}
