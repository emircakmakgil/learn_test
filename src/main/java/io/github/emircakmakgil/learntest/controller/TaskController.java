package io.github.emircakmakgil.learntest.controller;

import io.github.emircakmakgil.learntest.dto.task.CreateTaskDto;
import io.github.emircakmakgil.learntest.dto.task.DeleteTaskDto;
import io.github.emircakmakgil.learntest.dto.task.TaskListiningDto;
import io.github.emircakmakgil.learntest.dto.task.UpdateTaskDto;
import io.github.emircakmakgil.learntest.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<TaskListiningDto> getAll() {
        return this.taskService.getAll();
    }
    @PostMapping
    public void createTask(@RequestBody CreateTaskDto createTaskDto) {
        this.taskService.add(createTaskDto);
    }
    @PutMapping
    public void updateTask(@RequestBody UpdateTaskDto updateTaskDto) {
        this.taskService.update(updateTaskDto);
    }
    @DeleteMapping
    public void deleteTask(@RequestBody DeleteTaskDto deleteTaskDto) {
        this.taskService.delete(deleteTaskDto);
    }
}
