package com.soa.instakram.global.exception;

public class BusinessException extends RuntimeException {

    private final int status;


    public BusinessException(int status) {
        super();
    }
}
