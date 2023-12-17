package com.soa.instakram.follow.service;

import com.soa.instakram.follow.dto.FollowDto;
import com.soa.instakram.follow.entity.Follow;
import com.soa.instakram.follow.repository.FollowRepository;
import com.soa.instakram.global.error.exception.MemberNotFoundException;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowService {

    private  final FollowRepository followRepository;
    private final MemberRepository memberRepository;
    public void createFollow(final FollowDto followDto) {
        Follow follow = Follow.builder()
                .followingId(followDto.getFollowingId())
                .followedId(followDto.getFollowedId())
                .build();
        followRepository.save(follow);
        Member member1 = memberRepository.findById(followDto.getFollowingId())
                .orElseThrow(MemberNotFoundException::new);
        Member member2 = memberRepository.findById(followDto.getFollowedId())
                .orElseThrow(MemberNotFoundException::new);
        member1.setFollow(member1.getFollow()+1);
        member2.setFollowed(member2.getFollowed()+1);
    }

    public void delete(FollowDto followDto) {
        Follow follow = followRepository
                .findByFollowingIdAndFollowedId(followDto.getFollowingId(), followDto.getFollowedId())
                .orElseThrow(()-> new IllegalArgumentException("없는 팔로우입니다"));
        followRepository.delete(follow);
        Member member1 = memberRepository.findById(followDto.getFollowingId())
                .orElseThrow(MemberNotFoundException::new);
        Member member2 = memberRepository.findById(followDto.getFollowedId())
                .orElseThrow(MemberNotFoundException::new);
        member1.setFollow(member1.getFollow()-1);
        member2.setFollowed(member2.getFollowed()-1);
    }
}
