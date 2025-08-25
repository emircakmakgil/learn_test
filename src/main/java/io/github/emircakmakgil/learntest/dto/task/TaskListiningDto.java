package io.github.emircakmakgil.learntest.dto.task;

import io.github.emircakmakgil.learntest.model.enums.TaskType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskListiningDto {

    private String title;
    private String description;
    private boolean completed;
    private TaskType priority;

    public TaskListiningDto(String title, String description, TaskType priority) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.priority = priority;
    }

    public TaskListiningDto() {

    }
}
