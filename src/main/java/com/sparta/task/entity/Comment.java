package com.sparta.task.entity;

import com.sparta.task.dto.CommentSaveRequestDto;
import com.sparta.task.dto.CommentUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "contents", nullable = false)
    private String contents;
    @Column(name = "username", nullable = false) //null값으로 db에 들어가는거 방지 -> null 로 들어가면 에러!
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    public Comment(CommentSaveRequestDto commentSaveRequestDto) {
        this.contents = commentSaveRequestDto.getContents();
        this.username = commentSaveRequestDto.getUsername();
    }

    public void update(CommentUpdateRequestDto commentUpdateRequestDto) {
        this.contents = commentUpdateRequestDto.getContents();
        this.username = commentUpdateRequestDto.getUsername();
    }

}
