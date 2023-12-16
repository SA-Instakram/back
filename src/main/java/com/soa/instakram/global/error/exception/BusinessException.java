package com.soa.instakram.global.error.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final int status;

    public BusinessException(int status, String msg) {
        super(msg);
        this.status = status;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
