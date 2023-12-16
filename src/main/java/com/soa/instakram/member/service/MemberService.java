package com.soa.instakram.member.service;

import com.soa.instakram.global.exception.BusinessException;
import com.soa.instakram.member.dto.LoginDto;
import com.soa.instakram.member.dto.SignupDto;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public void singUp(final SignupDto signupDto) {

        String encodedPassword = passwordEncoder.encode(signupDto.getPassword());

        Member member = Member.builder()
                .email(signupDto.getEmail())
                .password(encodedPassword)
                .instaId(signupDto.getInstaId())
                .name(signupDto.getName())
                .createdTime(LocalDateTime.now())
                .follow(0)
                .followed(0)
                .build();
        memberRepository.save(member);
    }

    public void login(LoginDto loginDto) {
        // 아이디 비밀번호 체크
        String email = loginDto.getEmail();
        if (memberRepository.findByEmail(email).isEmpty()) {
            throw new BusinessException(500, "등록된 이메일이 존재하지 않습니다.");
        }
        Member member = memberRepository.findByEmail(email).orElseThrow(NoSuchElementException::new);
        // 토큰 발급
        if (!passwordEncoder.matches(loginDto.getPassword()))
    }
}
