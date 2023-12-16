package com.soa.instakram.profile.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfileDto {
    private String instaId;
    private String introduce;
    private String image;
    // private List<Post>
    private double follow;
    private double follower;
    private String name;
}
