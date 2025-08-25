package io.github.emircakmakgil.learntest.dto.task;

import io.github.emircakmakgil.learntest.model.enums.TaskType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateTaskDto {
    @NotNull
    private UUID id;

    private String title;
    private String description;
    private boolean completed;
    private TaskType priority;
}
