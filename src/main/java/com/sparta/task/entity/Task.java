package com.sparta.task.entity;

import com.sparta.task.dto.TaskSaveRequestDto;
import com.sparta.task.dto.TaskUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
@Getter
@NoArgsConstructor
public class Task extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "contents", nullable = false)
    private String contents;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments = new ArrayList<>();

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
