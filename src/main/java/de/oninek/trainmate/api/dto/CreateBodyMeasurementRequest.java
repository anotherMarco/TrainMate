package de.oninek.trainmate.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record CreateBodyMeasurementRequest(Double weight, Double fatPercentage, Double skeletalMuscleWeight,
                                           Double fatMassWeight, LocalDateTime measuredAt) implements Serializable {
}
