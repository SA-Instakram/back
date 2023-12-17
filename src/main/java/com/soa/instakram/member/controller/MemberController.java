package com.soa.instakram.member.controller;

import com.soa.instakram.member.dto.request.LoginDto;
import com.soa.instakram.member.dto.request.SignupDto;
import com.soa.instakram.member.dto.response.TokenResponseDto;
import com.soa.instakram.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid final SignupDto signupDto) {
        memberService.singUp(signupDto);
        return ResponseEntity.ok().body("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody @Valid LoginDto loginDto) {
        TokenResponseDto tokenResponseDto = memberService.login(loginDto);
        return ResponseEntity.ok().body(tokenResponseDto);
    }
}
