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
    public ResponseEntity<String> createComment(@RequestBody final CreateCommentDto createCommentDto) {
        commentService.createComment(createCommentDto);
        return ResponseEntity.ok().body("댓글 작성 완료");
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<String> editCommentDto(@PathVariable Long commentId, @RequestBody final EditCommentDto editCommentDto){
        commentService.editComment(commentId, editCommentDto);
        return ResponseEntity.ok().body("댓글 수정 완료");
    }

    @GetMapping("/{postId}")
    public List<CommentResponseDto> searchAll(@PathVariable Long postId) {
        return commentService.searchAll(postId);
    }


    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<String> delete(@PathVariable Long commentId){
        commentService.delete(commentId);
        return ResponseEntity.ok().body("댓글 삭제 완료");
    }

}
