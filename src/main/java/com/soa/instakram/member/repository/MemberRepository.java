package com.soa.instakram.member.repository;

import com.soa.instakram.member.entity.Member;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {

    void save(Member member);
    Member findByEmail(String email);
    Member findByInstaId(String instaId);
}
