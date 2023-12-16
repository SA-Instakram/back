package com.soa.instakram.comment.dto;

import com.soa.instakram.comment.entity.Comment;
import com.soa.instakram.post.entity.Post;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    final private Long commentId;
    final private String content;
    final private Long postId;


    public CommentResponseDto(Comment entity){
        this.commentId = entity.getCommentId();
        this.content = entity.getContent();
        this.postId = entity.getPostId();

    }
}
