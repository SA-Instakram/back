package com.soa.instakram.member.service;

import com.soa.instakram.member.dto.SignupDto;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void singUp(final SignupDto signupDto) {
        Member member = Member.builder()
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .instaId(signupDto.getInstaId())
                .name(signupDto.getName())
                .createdTime(LocalDateTime.now())
                .follow(0)
                .followed(0)
                .build();
        memberRepository.save(member);
    }
}
