package io.github.emircakmakgil.learntest.entity;

import io.github.emircakmakgil.learntest.model.enums.TaskType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @UuidGenerator
    private UUID id;

    private String title;
    private String description;
    private boolean completed;

    @Enumerated(EnumType.STRING)
    private TaskType priority; // e.g., "low", "medium", "high"

}
