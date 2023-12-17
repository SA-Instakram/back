package com.soa.instakram.profile.dto;

import com.soa.instakram.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProfileDto {
    private String instaId;
    private String introduce;
    private String image;
    private List<Post> posts;
    private String name;

    private boolean followState;
    private double follow;
    private double follower;
}
