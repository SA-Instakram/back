package com.soa.instakram.post.dto;

import com.soa.instakram.post.entity.Post;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class PostResponseDto {
    final private Long postId;
    final private String content;

    @Column(columnDefinition = "LONGTEXT")
    final private String image;

    final private String memberId;

    public PostResponseDto(Post entity){
        this.postId = entity.getPostId();
        this.content = entity.getContent();
        this.image = entity.getImage();
        this.memberId = entity.getMemberId();

    }
}
