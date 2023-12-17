package com.soa.instakram.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soa.instakram.member.entity.Member;
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
    private String instaId;

    @CreatedDate
    private LocalDateTime createdTime;

//    private  String memberId;
    private int likes;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    public void editPost(String content, String image){
        this.content = content;
        this.image  = image;
    }
}
