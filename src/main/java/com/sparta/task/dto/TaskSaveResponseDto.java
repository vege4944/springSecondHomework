package com.sparta.task.dto;

import com.sparta.task.entity.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class TaskSaveResponseDto {
    private final Long id;
    private final String author;
    private final String title;
    private final String contents;
    private final LocalDateTime dateCreated; // response 는 날짜를 반환해줘야 해서 내비둬! 요청할 때만 지우면 돼
    private final LocalDateTime dateModified;

    public TaskSaveResponseDto(Task task) {
        this.id = task.getId();
        this.author = task.getAuthor();
        this.title = task.getTitle();
        this.contents = task.getContents();
        this.dateCreated = task.getCreatedAt();
        this.dateModified = task.getUpdatedAt();
    }
}

