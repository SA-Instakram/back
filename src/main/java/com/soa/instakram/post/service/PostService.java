package com.soa.instakram.post.service;


import com.soa.instakram.global.error.exception.MemberNotFoundException;
import com.soa.instakram.global.error.exception.PostNotFoundException;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.repository.MemberRepository;
import com.soa.instakram.post.dto.CreatePostDto;
import com.soa.instakram.post.dto.EditPostDto;
import com.soa.instakram.post.dto.PostResponseDto;
import com.soa.instakram.post.entity.Post;
import com.soa.instakram.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public void createPost(final CreatePostDto createPostDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);

        Post post = Post.builder()
                .content(createPostDto.getContent())
                .createdTime(LocalDateTime.now())
                .image(createPostDto.getImage())
                .member(member)
                .build();
        postRepository.save(post);
    }

    @Transactional
    public void editPost(final Long postId, final EditPostDto editPostDto){
        Post post = postRepository.findByPostId(postId)
                .orElseThrow(PostNotFoundException::new);
        post.editPost(editPostDto.getContent(),
                editPostDto.getImage());
    }

    @Transactional
    public List<PostResponseDto> searchAll(){
        return postRepository.findAllByOrderByPostId()
                .stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePost(Long postId){
        Post post = postRepository.findByPostId(postId)
                .orElseThrow(PostNotFoundException::new);
        postRepository.delete(post);
    }
}
