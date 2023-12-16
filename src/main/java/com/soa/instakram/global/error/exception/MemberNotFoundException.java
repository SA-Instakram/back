package com.soa.instakram.global.error.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends BusinessException{
    public MemberNotFoundException() {
        super(HttpStatus.BAD_REQUEST.value(), "해당 멤버가 존재하지 않습니다.");
    }
}
