package com.sparta.task.service;

import com.sparta.task.dto.*;
import com.sparta.task.entity.Task;
import com.sparta.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public TaskSaveResponseDto saveTask(TaskSaveRequestDto taskSaveRequestDto) {
        Task newTask = new Task(taskSaveRequestDto);
        Task savedTask = taskRepository.save(newTask);

        return new TaskSaveResponseDto(savedTask);
    }

    public TaskSimpleResponseDto getTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new IllegalArgumentException("SORRY! OUT OF RESULT. :( PLEASE TRY AGAIN!"));

        return new TaskSimpleResponseDto(task);
    }

    @Transactional
    public TaskUpdateResponseDto updateTask(Long taskId, TaskUpdateRequestDto taskUpdateRequestDto) {
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new IllegalArgumentException("SORRY! OUT OF RESULT. :( PLEASE TRY AGAIN!"));

        task.update(taskUpdateRequestDto);

        return new TaskUpdateResponseDto(task);
    }
}














