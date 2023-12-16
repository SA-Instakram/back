package com.soa.instakram.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponseDto {

    private String accessToken;
}
