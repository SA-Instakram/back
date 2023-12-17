package com.soa.instakram.post.repository;


import com.soa.instakram.post.entity.Post;
import org.springframework.data.repository.Repository;


import java.util.Optional;
import java.util.List;

public interface PostRepository extends Repository<Post, Long> {

    void save(Post post);

    Optional<Post> findByPostId(Long postId);
    

    List<Post> findAllByOrderByPostId();

    void delete(Post post);

    Optional<Post> findByMemberIdIn(List<String> instIds);
}
