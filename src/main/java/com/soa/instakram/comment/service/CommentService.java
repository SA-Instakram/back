package com.soa.instakram.comment.service;


import com.soa.instakram.comment.dto.CommentResponseDto;
import com.soa.instakram.comment.dto.CreateCommentDto;
import com.soa.instakram.comment.dto.EditCommentDto;
import com.soa.instakram.comment.entity.Comment;
import com.soa.instakram.comment.repository.CommentRepository;
import com.soa.instakram.global.error.exception.CommentNotFoundException;
import com.soa.instakram.post.dto.PostResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void createComment(final CreateCommentDto createCommentDto){
        Comment comment = Comment.builder()
                .content(createCommentDto.getContent())
                .commentedTime(LocalDateTime.now())
                .postId(createCommentDto.getPostId())
                .memberId(createCommentDto.getMemberId())
                .build();
        commentRepository.save(comment);
    }

    @Transactional
    public Long editComment(final Long commentId, final EditCommentDto editCommentDto){
        Comment comment = commentRepository.findByCommentId(commentId)
                .orElseThrow(CommentNotFoundException::new);
        comment.editComment(editCommentDto.getContent());

        return commentId;

    }

    @Transactional
    public List<CommentResponseDto> searchAll(final Long postId){
        return commentRepository.findAllByPostIdOrderByCommentId(postId)
                .stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long postId){
        Comment comment = commentRepository.findByCommentId(postId)
                .orElseThrow(CommentNotFoundException::new);
        commentRepository.delete(comment);
    }
}
