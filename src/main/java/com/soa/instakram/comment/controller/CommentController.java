package com.soa.instakram.comment.controller;


import com.soa.instakram.comment.dto.CommentResponseDto;
import com.soa.instakram.comment.dto.CreateCommentDto;
import com.soa.instakram.comment.dto.EditCommentDto;
import com.soa.instakram.comment.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<?> createComment(@RequestBody final CreateCommentDto createCommentDto) {
        log.info("bbbbb");
        commentService.createComment(createCommentDto);
        return ResponseEntity.ok().body("댓글 작성완료");
    }

    @PutMapping("/{commentId}")
    public Long editCommentDto(@PathVariable Long commentId, @RequestBody final EditCommentDto editCommentDto){
        return commentService.editComment(commentId, editCommentDto);

    }

    @GetMapping("/{postId}")
    public List<CommentResponseDto> serachAll(@PathVariable Long postId) {
        log.info((commentService.searchAll(postId).toString()));
        return commentService.searchAll(postId);
    }


    @DeleteMapping("/delete/{commentId}")
    public void delete(@PathVariable Long commentId){
        commentService.delete(commentId);
    }


}
