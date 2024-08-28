package com.sparta.task.controller;


import com.sparta.task.dto.*;
import com.sparta.task.service.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment (@RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return ResponseEntity.ok(commentService.saveComment(commentSaveRequestDto));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDetailResponseDto>> getTasks () {
        return ResponseEntity.ok(commentService.getComments());
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentSimpleResponseDto> getComment (
            @PathVariable Long commentId
    ) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment (
            @PathVariable Long commentId,
            @RequestBody CommentUpdateRequestDto commentUpdateRequestDto
    ) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentUpdateRequestDto));
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(
            @PathVariable Long commentId
    ) {
        commentService.deleteComment(commentId);
    }
}
