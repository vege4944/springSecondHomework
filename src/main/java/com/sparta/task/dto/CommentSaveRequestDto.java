package com.sparta.task.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveRequestDto {
    private Long id;
    private String contents;
    private String username;
}
