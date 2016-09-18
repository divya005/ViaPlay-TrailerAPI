package com.viaplay.trailer.exceptions;

import com.viaplay.trailer.model.StatusCode;

public class TmdbInvalidResponseException extends BaseException{
    public TmdbInvalidResponseException(String msg, StatusCode statusCode) {
        super(msg, statusCode);
    }
}
