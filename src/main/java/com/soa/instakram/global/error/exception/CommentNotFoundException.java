package com.soa.instakram.global.error.exception;

import org.springframework.http.HttpStatus;

public class CommentNotFoundException extends BusinessException {
    public CommentNotFoundException() {
        super(HttpStatus.BAD_REQUEST.value(), "해당 댓글이 존재하지 않습니다.");
    }
}
