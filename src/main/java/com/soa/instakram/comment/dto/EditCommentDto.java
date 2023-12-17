package com.soa.instakram.comment.dto;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class EditCommentDto {
    private String content;

    public EditCommentDto(String content){
        this.content = content;
    }
}
