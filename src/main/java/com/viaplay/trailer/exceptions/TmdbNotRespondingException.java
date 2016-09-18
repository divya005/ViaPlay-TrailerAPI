package com.viaplay.trailer.exceptions;

import com.viaplay.trailer.model.StatusCode;

public class TmdbNotRespondingException extends BaseException{
    public TmdbNotRespondingException(String msg, StatusCode statusCode) {
        super(msg, statusCode);
    }
}
