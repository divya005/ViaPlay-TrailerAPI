package com.viaplay.trailer.exceptions;

import com.viaplay.trailer.model.StatusCode;

public class TmdbEmptyResponseException extends BaseException{
    public TmdbEmptyResponseException(String msg, StatusCode statusCode) {
        super(msg, statusCode);
    }
}
