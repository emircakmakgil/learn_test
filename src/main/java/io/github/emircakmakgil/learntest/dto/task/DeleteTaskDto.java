package io.github.emircakmakgil.learntest.dto.task;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteTaskDto {
    @NotNull
    private UUID id;
}
