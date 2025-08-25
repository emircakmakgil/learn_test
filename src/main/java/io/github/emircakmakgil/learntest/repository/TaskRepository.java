package io.github.emircakmakgil.learntest.repository;

import io.github.emircakmakgil.learntest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
