package com.soa.instakram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    @CreatedDate
    private LocalDateTime createdTime;

    private String image;
    private String introduce;
    private double follow;
    private double followed;
    private String gender;
    private String phone;
}
