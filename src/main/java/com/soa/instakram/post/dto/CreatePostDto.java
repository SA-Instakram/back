package com.soa.instakram.post.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostDto {

    @Column(columnDefinition = "LONGTEXT")
    @NotBlank(message = "이미지를 등록하세요")
    private String image;
    @NotBlank(message = "글을 작성하세요")
    private String content;
    private String memberId;

}
