package com.viaplay.trailer.exceptions;

import com.viaplay.trailer.model.StatusCode;

public abstract class BaseException extends Exception{

    String msg;
    StatusCode statusCode;


    public BaseException(String msg, StatusCode statusCode) {
        super();
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }
}
