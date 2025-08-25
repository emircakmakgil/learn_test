package io.github.emircakmakgil.learntest.service;

import io.github.emircakmakgil.learntest.dto.task.CreateTaskDto;
import io.github.emircakmakgil.learntest.dto.task.DeleteTaskDto;
import io.github.emircakmakgil.learntest.dto.task.TaskListiningDto;
import io.github.emircakmakgil.learntest.dto.task.UpdateTaskDto;
import io.github.emircakmakgil.learntest.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    void add(CreateTaskDto createTaskDto);
    Task update(UpdateTaskDto updateTaskDto);
    void delete(DeleteTaskDto deleteTaskDto);
    List<TaskListiningDto> getAll();
    Optional<Task> findById(UUID id);

}
