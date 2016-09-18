package com.viaplay.trailer.exceptions;

import com.viaplay.trailer.model.StatusCode;

public class ViaplayNotRespondingException extends BaseException{

    public ViaplayNotRespondingException(String msg, StatusCode statusCode) {
        super(msg, statusCode);
    }
}
