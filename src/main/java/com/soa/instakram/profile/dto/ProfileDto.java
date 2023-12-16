package com.soa.instakram.profile.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfileDto {
    private String instaId;
    private String introduce;
    private String image;
    // private List<Post>
    private String name;
    private double follow;
    private double follower;
}
