package com.sparta.task.dto;

import com.sparta.task.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDetailResponseDto {
    private final Long id;
    private final String contents;
    private final String username;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateModified;

    public CommentDetailResponseDto(Comment comment) {
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.username = comment.getUsername();
        this.dateCreated = comment.getCreatedAt();
        this.dateModified = comment.getUpdatedAt();
    }
}
