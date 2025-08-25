package io.github.emircakmakgil.learntest.service;

import io.github.emircakmakgil.learntest.dto.task.CreateTaskDto;
import io.github.emircakmakgil.learntest.entity.Task;
import io.github.emircakmakgil.learntest.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static io.github.emircakmakgil.learntest.model.enums.TaskType.high;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @InjectMocks
    private TaskServiceImpl taskService;
    @Mock
    private TaskRepository taskRepository;

    private UUID id;
    private Task task;
    private CreateTaskDto createTaskDto;

    @BeforeEach
    void setup() {
        // Initialize any necessary objects or mocks before each test
        // This can include setting up mock behaviors or creating test data
        // Example:
        id = UUID.randomUUID();
        task = new Task();
        task.setId(id);
        task.setTitle("Test Task");
        task.setDescription("This is a test task description.");
        task.setCompleted(false);
        task.setPriority(high);

        createTaskDto = new CreateTaskDto();
        createTaskDto.setTitle("Test Task");
        createTaskDto.setDescription("This is a test task description.");
        createTaskDto.setPriority(high);
    }
    @Test
     void whenAddCalledWithValidRequest_itShouldSaveTaskToRepository() {
        // Arrange - Test verilerini ve beklenen davranışları ayarlıyoruz
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        // Act - Test edilecek metodu çağırıyoruz
        taskService.add(createTaskDto);

        // Assert - Beklenen sonuçları doğruluyoruz
        verify(taskRepository, times(1)).save(any(Task.class));
    }
    @Test
    void whenFindByIdCalledWithValidId_itShouldReturnTask() {
        // Arrange
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));

        // Act
        Optional<Task> result = taskService.findById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(task, result.get());
        verify(taskRepository, times(1)).findById(id);
    }
}