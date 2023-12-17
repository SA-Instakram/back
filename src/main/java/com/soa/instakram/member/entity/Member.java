package com.soa.instakram.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soa.instakram.post.entity.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String instaId;
    @NotNull
    private String name;


    @CreatedDate
    private LocalDateTime createdTime;
    private String role;
    private String image;
    private String introduce;
    private double follow;
    private double followed;
    private String gender;
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();
}
