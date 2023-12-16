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
        log.info("asfsfsfs");
        Member member = memberRepository.findByInstaId(instaId)
                .orElseThrow(MemberNotFoundException::new);

        return ProfileDto.builder()
                .instaId(member.getInstaId())
                .introduce(member.getIntroduce())
                .image(member.getImage())
                .name(member.getName())
                .build();
    }

    public void modifyProfile(ModifyDetails modifyDetails) {
        Member member = memberRepository.findByInstaId(modifyDetails.getInstaId())
                .orElseThrow(MemberNotFoundException::new);

        member.setIntroduce(modifyDetails.getIntroduce());
        member.setImage(modifyDetails.getImage());

        memberRepository.save(member);
    }
}
