package com.soa.instakram.global.error.exception;

public class TokenNotValidateException extends BusinessException{
    public TokenNotValidateException(String msg) {
        super(401, msg);
    }
}
