package io.github.emircakmakgil.learntest.service;

import io.github.emircakmakgil.learntest.dto.task.CreateTaskDto;
import io.github.emircakmakgil.learntest.dto.task.DeleteTaskDto;
import io.github.emircakmakgil.learntest.dto.task.TaskListiningDto;
import io.github.emircakmakgil.learntest.dto.task.UpdateTaskDto;
import io.github.emircakmakgil.learntest.entity.Task;
import io.github.emircakmakgil.learntest.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(CreateTaskDto createTaskDto) {
        // Implementation for adding a task
        Task task = new Task();
        task.setTitle(createTaskDto.getTitle());
        task.setDescription(createTaskDto.getDescription());
        task.setCompleted(createTaskDto.isCompleted());
        task.setPriority(createTaskDto.getPriority());
        taskRepository.save(task);

    }

    @Override
    public Task update(UpdateTaskDto updateTaskDto) {
        Task task = taskRepository.findById(updateTaskDto.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updateTaskDto.getTitle());
        task.setDescription(updateTaskDto.getDescription());
        task.setCompleted(updateTaskDto.isCompleted());
        task.setPriority(updateTaskDto.getPriority());
        return taskRepository.save(task);
    }

    @Override
    public void delete(DeleteTaskDto deleteTaskDto) {
        Task task = taskRepository.findById(deleteTaskDto.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);

    }

    @Override
    public List<TaskListiningDto> getAll() {
    List<TaskListiningDto> tasks = taskRepository
            .findAll()
            .stream()
            .map((task)->new TaskListiningDto(task.getTitle(),task.getDescription(),task.getPriority()))
            .toList();
    return tasks;
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return taskRepository.findById(id);
    }

}

