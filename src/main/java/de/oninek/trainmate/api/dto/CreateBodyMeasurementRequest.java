package de.oninek.trainmate.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

public record CreateBodyMeasurementRequest(
        @Schema(description = "the measured weight in kg", example = "72.0") Double weight,
        @Schema(description = "body fat in kg", example = "20.5") Double fatMassWeight,
        @Schema(description = "the weight of the skeletal muscle in kg", example = "30.5") Double skeletalMuscleWeight,
        @Schema(description = "the time when the measurement was made", example = "2023-06-11T00:00") LocalDateTime measuredAt
) implements Serializable {
}
