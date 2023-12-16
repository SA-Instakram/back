package com.soa.instakram.comment.entity;

import jakarta.persistence.*;
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
public class Comment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long commentId;
    private String content;

    @CreatedDate
    private LocalDateTime commentedTime;

    private Long postId;
    private String memberId;

    public void editComment(String content){
        this.content = content;
    }
}
