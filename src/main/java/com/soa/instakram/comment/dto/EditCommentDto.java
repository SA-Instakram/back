package com.soa.instakram.comment.dto;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EditCommentDto {
    private String content;

    public EditCommentDto(String content){
        this.content = content;
    }
}
