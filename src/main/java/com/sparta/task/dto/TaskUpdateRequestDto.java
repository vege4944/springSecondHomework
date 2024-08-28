package com.sparta.task.dto;

import lombok.Getter;


@Getter
public class TaskUpdateRequestDto {
    private String author;
    private String title;
    private String contents;
}

