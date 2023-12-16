package com.soa.instakram.post.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long postId;
    private String content;
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    @CreatedDate
    private LocalDateTime createdTime;

    private  String memberId;
    private  int likes;

    public void editPost(String content, String image){
        this.content = content;
        this.image  = image;
    }
}
