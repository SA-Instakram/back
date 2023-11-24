package com.soa.instakram.global;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ErrorResponse {
    private final int status;
    private final List<String> message;
}
