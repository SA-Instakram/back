package com.soa.instakram.global.error.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends BusinessException {
    public InvalidRequestException() {
        super(HttpStatus.BAD_REQUEST.value(), "유효하지 않은 요청입니다.");
    }
}
