package com.soa.instakram.member.service;

import com.soa.instakram.global.error.exception.MemberNotFoundException;
import com.soa.instakram.global.error.exception.PasswordNotMatchException;
import com.soa.instakram.jwt.utils.JwtProvider;
import com.soa.instakram.member.dto.request.LoginDto;
import com.soa.instakram.member.dto.request.SignupDto;
import com.soa.instakram.member.dto.response.TokenResponseDto;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    public void singUp(final SignupDto signupDto) {

        String encodedPassword = passwordEncoder.encode(signupDto.getPassword());

        Member member = Member.builder()
                .email(signupDto.getEmail())
                .password(encodedPassword)
                .instaId(signupDto.getInstaId())
                .name(signupDto.getName())
                .createdTime(LocalDateTime.now())
                .role("ROLE_USER")
                .follow(0)
                .followed(0)
                .build();
        memberRepository.save(member);
    }

    public TokenResponseDto login(LoginDto loginDto) {
        // 아이디 비밀번호 체크
        String email = loginDto.getEmail();
        Member member = memberRepository.findByEmail(email).orElse(null);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        if (!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
            throw new PasswordNotMatchException();
        }

        String accessToken = jwtProvider.generateToken(member);
        return TokenResponseDto.builder().accessToken(accessToken).build();
    }
}
