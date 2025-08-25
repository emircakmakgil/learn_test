package io.github.emircakmakgil.learntest.controller;

import io.github.emircakmakgil.learntest.dto.task.CreateTaskDto;
import io.github.emircakmakgil.learntest.dto.task.DeleteTaskDto;
import io.github.emircakmakgil.learntest.dto.task.TaskListiningDto;
import io.github.emircakmakgil.learntest.dto.task.UpdateTaskDto;
import io.github.emircakmakgil.learntest.entity.Task;
import io.github.emircakmakgil.learntest.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.UUID;

import static io.github.emircakmakgil.learntest.model.enums.TaskType.high;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class TaskControllerTest {
    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private UUID id;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTask() {
        // Arrange
        CreateTaskDto createTaskDto = new CreateTaskDto();
        doNothing().when(taskService).add(any(CreateTaskDto.class));

        // Act
        taskController.createTask(createTaskDto);

        // Assert
        verify(taskService, times(1)).add(any(CreateTaskDto.class));
    }
    @Test
    void getAllTasks() {
        TaskListiningDto taskListiningDto = new TaskListiningDto();
        taskListiningDto.setTitle("Test Task");
        taskListiningDto.setDescription("This is a test task description.");
        taskListiningDto.setCompleted(false);
        taskListiningDto.setPriority(high);
        List<TaskListiningDto> taskListiningDtos = List.of(taskListiningDto);

        // Arrange
        when(taskService.getAll()).thenReturn(taskListiningDtos);

        // Act
        List<TaskListiningDto> response = taskController.getAll();

        // Assert
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals("Test Task", response.get(0).getTitle());
        assertEquals("This is a test task description.", response.get(0).getDescription());
        assertFalse(response.get(0).isCompleted());
        assertEquals(high, response.get(0).getPriority());

        verify(taskService, times(1)).getAll();
    }
    @Test
    void deleteTask(){
        id=UUID.randomUUID();
        DeleteTaskDto deleteTaskDto = new DeleteTaskDto();
        deleteTaskDto.setId(id);
        doNothing().when(taskService).delete(any(DeleteTaskDto.class));
        taskController.deleteTask(deleteTaskDto);
        verify(taskService, times(1)).delete(any(DeleteTaskDto.class));
    }
    @Test
    void updateTask(){
        id = UUID.randomUUID();
        UpdateTaskDto updateTaskDto = new UpdateTaskDto();
        updateTaskDto.setTitle("Updated Task");
        updateTaskDto.setDescription("This is an updated task description.");
        updateTaskDto.setPriority(high);
        updateTaskDto.setId(id);

        when(taskService.update(any(UpdateTaskDto.class))).thenReturn(new Task());

        // Act
        taskController.updateTask(updateTaskDto);

        // Assert
        verify(taskService, times(1)).update(any(UpdateTaskDto.class));
    }
    @Test
    void addTask_argumentCaptorExample() {
        // Arrange
        CreateTaskDto createTaskDto = new CreateTaskDto();
        createTaskDto.setTitle("Test Task");
        createTaskDto.setDescription("This is a test task description.");

        // Act
        taskController.createTask(createTaskDto);

        // Assert
        ArgumentCaptor<CreateTaskDto> captor = ArgumentCaptor.forClass(CreateTaskDto.class);
        verify(taskService).add(captor.capture()); // Servisin çağrıldığı argümanı yakala
        assertEquals("Test Task", captor.getValue().getTitle());
        assertEquals("This is a test task description.", captor.getValue().getDescription());
    }


}