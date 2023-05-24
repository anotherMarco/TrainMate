package de.oninek.trainmate.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record MuscleGroupResponse(@Schema(requiredMode = REQUIRED)Long id, @Schema(requiredMode = REQUIRED)String name) {
}
