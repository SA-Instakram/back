package com.soa.instakram.follow.repository;

import com.soa.instakram.follow.entity.Follow;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends Repository<Follow, Long> {

    void save(Follow follow);

    void delete(Follow follow);

    Optional<Follow> findByFollowingIdAndFollowedId(Long followingId, Long followedId);


    List<Long> findFollowingIdListByFollowingId(Long followerId);
}
