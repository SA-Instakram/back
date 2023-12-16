package com.soa.instakram.global.validation;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ValidErrorResponse {
    private final int status;
    private final List<String> message;
}
