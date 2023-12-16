package com.soa.instakram.profile.service;

import com.soa.instakram.global.error.exception.MemberNotFoundException;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.repository.MemberRepository;
import com.soa.instakram.profile.dto.response.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private MemberRepository memberRepository;
    public ProfileDto getProfile(String instaId) {
        Member member = memberRepository.findByInstaId(instaId)
                .orElseThrow(MemberNotFoundException::new);

        return ProfileDto.builder()
                .instaId(member.getInstaId())
                .introduce(member.getIntroduce())
                .image(member.getImage())
                .follow(member.getFollow())
                .follower(member.getFollowed())
                .name(member.getName())
                .build();
    }
}
