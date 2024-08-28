package com.sparta.task.dto;


import com.sparta.task.entity.Task;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskUpdateResponseDto {
    private final Long id;
    private final String author;
    private final String title;
    private final String contents;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateModified;

    public TaskUpdateResponseDto(Task task) {
        this.id = task.getId();
        this.author = task.getAuthor();
        this.title = task.getTitle();
        this.contents = task.getContents();
        this.dateCreated = task.getCreatedAt();
        this.dateModified = task.getUpdatedAt();
    }
}
