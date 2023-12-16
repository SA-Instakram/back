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
    public ResponseEntity<?> createpost(@RequestBody final CreatePostDto createpostDto) {
        log.info("aaaaa");
        postService.createPost(createpostDto);
        return ResponseEntity.ok().body("글 작성완료");
    }

    @PutMapping("/{postId}")
    public Long editPostDto(@PathVariable Long postId, @RequestBody final EditPostDto editPostDto){
        return postService.editPost(postId, editPostDto);

    }

    @GetMapping("/allpost")
    public List<PostResponseDto> serachAll() {
        return postService.searchAll();
    }


    @DeleteMapping("/delete/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }


}
