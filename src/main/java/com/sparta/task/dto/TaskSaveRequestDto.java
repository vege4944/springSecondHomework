package com.sparta.task.dto;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class TaskSaveRequestDto {
    private Long id;
    private String author;
    private String title;
    private String contents;
}
