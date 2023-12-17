package com.soa.instakram.profile.service;

import com.soa.instakram.global.error.exception.InvalidRequestException;
import com.soa.instakram.global.error.exception.MemberNotFoundException;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.repository.MemberRepository;
import com.soa.instakram.profile.dto.ModifyDetails;
import com.soa.instakram.profile.dto.ProfileDto;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {

    private final MemberRepository memberRepository;
    public ProfileDto getProfile(String instaId) {
        Member member = memberRepository.findByInstaId(instaId)
                .orElseThrow(MemberNotFoundException::new);

        return ProfileDto.builder()
                .instaId(member.getInstaId())
                .introduce(member.getIntroduce())
                .image(member.getImage())
                .name(member.getName())
                .posts(member.getPosts())
                .build();
    }

    public void modifyProfile(ModifyDetails modifyDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);

        member.setInstaId(modifyDetails.getInstaId());
        member.setIntroduce(modifyDetails.getIntroduce());
        member.setImage(modifyDetails.getImage());
        member.setName(modifyDetails.getName());

        memberRepository.save(member);
    }
}
