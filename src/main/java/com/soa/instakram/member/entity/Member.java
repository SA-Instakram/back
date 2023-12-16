package com.soa.instakram.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

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
}
