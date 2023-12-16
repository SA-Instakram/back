package com.soa.instakram.post.dto;

import com.soa.instakram.post.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    final private Long postId;
    final private String content;
    final private String image;

    public PostResponseDto(Post entity){
        this.postId = entity.getPostId();
        this.content = entity.getImage();
        this.image = entity.getImage();

    }
}
