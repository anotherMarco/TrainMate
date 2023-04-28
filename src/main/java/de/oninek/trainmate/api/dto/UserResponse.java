package de.oninek.trainmate.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public record UserResponse(
       @Schema(example = "1") Long id,
       @Schema(example = "John") String firstName,
       @Schema(example = "Doe") String lastName,
       @Schema(example = "jd@example.com") String email,
       @Schema(example = "johnDoe") String displayName,
        BodyMeasurementResponse bodyMeasurement
) implements Serializable {
}
