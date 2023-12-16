package com.soa.instakram.global.error.exception;

import org.springframework.http.HttpStatus;

public class PasswordNotMatchException extends BusinessException{

    public PasswordNotMatchException() {
        super(HttpStatus.BAD_REQUEST.value(), "아이디 또는 비밀번호가 틀립니다.");
    }
}
