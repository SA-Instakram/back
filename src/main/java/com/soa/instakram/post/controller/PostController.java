package com.soa.instakram.post.controller;


import com.soa.instakram.post.dto.CreatePostDto;
import com.soa.instakram.post.dto.EditPostDto;
import com.soa.instakram.post.dto.PostResponseDto;
import com.soa.instakram.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody final CreatePostDto createpostDto) {
        postService.createPost(createpostDto);
        return ResponseEntity.ok().body("게시글 작성 완료");
    }

    @PutMapping("/modify/{postId}")
    public ResponseEntity<String> editPostDto(@PathVariable Long postId, @RequestBody final EditPostDto editPostDto){
        postService.editPost(postId, editPostDto);
        return ResponseEntity.ok().body("게시글 수정 완료");
    }

    @GetMapping("/allpost")
    public List<PostResponseDto> searchAll() {
        return postService.searchAll();
    }


    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return ResponseEntity.ok().body("게시글 삭제 완료");
    }

}
