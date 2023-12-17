package com.soa.instakram.follow.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FollowDto {

    private Long followingId;
    private Long followedId;

}
