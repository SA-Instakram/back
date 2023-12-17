package com.soa.instakram.post.dto;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
public class EditPostDto {
    private String content;
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    public EditPostDto(String content, String image){
        this.content = content;
        this.image = image;
    }
}
