package com.soa.instakram.member.service;

import com.soa.instakram.global.error.exception.MemberNotFoundException;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.entity.PrincipalDetail;
import com.soa.instakram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        return new PrincipalDetail(member);
    }
}
