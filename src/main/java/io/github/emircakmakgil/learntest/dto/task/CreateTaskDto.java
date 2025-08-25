package io.github.emircakmakgil.learntest.dto.task;

import io.github.emircakmakgil.learntest.model.enums.TaskType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskDto {
    private String title;
    private String description;
    private boolean completed;
    private TaskType priority;
}
