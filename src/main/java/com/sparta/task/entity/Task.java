package com.sparta.task.entity;

import com.sparta.task.dto.TaskSaveRequestDto;
import com.sparta.task.dto.TaskUpdateRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Task extends TimeStamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String contents;

    public Task(TaskSaveRequestDto taskSaveRequestDto) {
        this.author = taskSaveRequestDto.getAuthor();
        this.title = taskSaveRequestDto.getTitle();
        this.contents = taskSaveRequestDto.getContents();
    }


    public void update(TaskUpdateRequestDto taskUpdateRequestDto) {
        this.author = taskUpdateRequestDto.getAuthor();
        this.title = taskUpdateRequestDto.getTitle();
        this.contents = taskUpdateRequestDto.getContents();
    }
}
