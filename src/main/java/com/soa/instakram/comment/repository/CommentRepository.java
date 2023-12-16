package com.soa.instakram.comment.repository;

import com.soa.instakram.comment.entity.Comment;
import com.soa.instakram.post.entity.Post;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends Repository<Comment, Long> {
    void save(Comment comment);

    Optional<Comment> findByCommentId(Long commentId);

    void delete(Comment comment);

    List<Comment> findAllByPostIdOrderByCommentId(Long postId);
}
