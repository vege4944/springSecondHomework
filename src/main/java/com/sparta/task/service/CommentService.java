package com.sparta.task.service;

import com.sparta.task.dto.*;
import com.sparta.task.entity.Comment;
import com.sparta.task.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(CommentSaveRequestDto commentSaveRequestDto) {
        Comment newComment = new Comment(commentSaveRequestDto);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment);
    }

    public List<CommentDetailResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentDetailResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentDetailResponseDto(comment));
        }
        return dtoList;
    }

    public CommentSimpleResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->new IllegalArgumentException("SORRY! OUT OF RESULT. :( PLEASE TRY AGAIN!"));
        return new CommentSimpleResponseDto(comment);
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException("SORRY! OUT OF RESULT. :( PLEASE TRY AGAIN!"));
        comment.update(commentUpdateRequestDto);

        return new CommentUpdateResponseDto(comment);
    }

    @Transactional
    public void deleteComment (Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException("SORRY! OUT OF RESULT. :( PLEASE TRY AGAIN!"));
        commentRepository.delete(comment);
    }
}
