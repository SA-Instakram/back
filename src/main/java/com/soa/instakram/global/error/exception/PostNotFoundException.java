package com.soa.instakram.global.error.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends BusinessException {
    public PostNotFoundException() {
        super(HttpStatus.BAD_REQUEST.value(), "해당 포스트가 존재하지 않습니다.");
    }
}
