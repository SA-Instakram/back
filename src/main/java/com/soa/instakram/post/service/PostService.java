package com.soa.instakram.post.service;


import com.soa.instakram.post.dto.CreatePostDto;
import com.soa.instakram.post.dto.EditPostDto;
import com.soa.instakram.post.dto.PostResponseDto;
import com.soa.instakram.post.entity.Post;
import com.soa.instakram.post.repository.PostRepository;
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
public class PostService {

    private final PostRepository postRepository;

    public void createPost(final CreatePostDto createPostDto){

        //.memberid 구현 필요
        Post post = Post.builder()
                .content(createPostDto.getContent())
                .createdTime(LocalDateTime.now())
                .image(createPostDto.getImage())
                .build();
        postRepository.save(post);
    }

    @Transactional
    public  Long editPost(final Long postId, final EditPostDto editPostDto){
        Post post = postRepository.findByPostId(postId)
                .orElseThrow(()-> new
                        IllegalArgumentException("에러"));
        post.editPost(editPostDto.getContent(),
                editPostDto.getImage());

        return postId;

    }

    @Transactional
    public List<PostResponseDto> searchAll(){
        return postRepository.findAllByOrderByPostId()
                .stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long postId){
        Post post = postRepository.findByPostId(postId)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물은 존재하지 않습니다"));

        postRepository.delete(post);
    }
}
