package de.oninek.trainmate.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record ExerciseResponse(@Schema(requiredMode = REQUIRED) Long id,
                               @Schema(requiredMode = REQUIRED) String name,
                               Set<String> mainMuscles,
                               Set<String> supportedMuscles,
                               Set<String> equipments) {
}
