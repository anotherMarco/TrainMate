package de.oninek.trainmate.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record MuscleResponse(
        @Schema(requiredMode = REQUIRED)
        Long id,
        String name,
        Long muscleGroupId,
        String muscleGroupName
) implements Serializable {
}
