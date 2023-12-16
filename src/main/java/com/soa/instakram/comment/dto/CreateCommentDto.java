package com.soa.instakram.comment.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCommentDto {

    @NotBlank(message = "글을 작성하세요")
    private String content;
    private Long postId;
    private String memberId;

}
