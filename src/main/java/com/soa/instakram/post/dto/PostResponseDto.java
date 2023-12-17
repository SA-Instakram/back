package com.soa.instakram.post.dto;

import com.soa.instakram.post.entity.Post;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    final private Long postId;
    final private String content;

    @Column(columnDefinition = "LONGTEXT")
    final private String image;

    final private String member_id;
    final  private Long created_time;
    final private int like;

    public PostResponseDto(Post entity){
        this.postId = entity.getPostId();
        this.content = entity.getContent();
        this.image = entity.getImage();
        this.member_id = entity.getMember().getInstaId();
        this.created_time = Duration.between(entity.getCreatedTime(),LocalDateTime.now()).toHours();
        this.like = entity.getLikes();

    }
}
