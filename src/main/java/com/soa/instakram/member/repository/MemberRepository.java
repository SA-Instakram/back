package com.soa.instakram.member.repository;

import com.soa.instakram.member.entity.Member;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface MemberRepository extends Repository<Member, Long> {

    void save(Member member);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByInstaId(String instaId);
}
