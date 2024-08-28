package com.sparta.task.controller;


import com.sparta.task.dto.*;
import com.sparta.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class TaskController {

    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<TaskSaveResponseDto> saveTask (@RequestBody TaskSaveRequestDto taskSaveRequestDto) {
        return ResponseEntity.ok(taskService.saveTask(taskSaveRequestDto));
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskSimpleResponseDto> getTask (
            @PathVariable Long taskId
    ) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<TaskUpdateResponseDto> updateTask (
            @PathVariable Long taskId,
            @RequestBody TaskUpdateRequestDto taskUpdateRequestDto
    ) {
        return ResponseEntity.ok(taskService.updateTask(taskId, taskUpdateRequestDto));
    }
}
