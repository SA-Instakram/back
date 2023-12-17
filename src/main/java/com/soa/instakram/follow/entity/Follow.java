package com.soa.instakram.follow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Follow {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long followId;

    private Long followingId;
    private Long followedId;

}
