package de.oninek.trainmate.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record BodyMeasurementResponse(
        Long id,
        Double weight,
        Double fatPercentage,
        Double skeletalMuscleWeight,
        Double fatMassWeight,
        LocalDateTime measuredAt
) implements Serializable {
}
