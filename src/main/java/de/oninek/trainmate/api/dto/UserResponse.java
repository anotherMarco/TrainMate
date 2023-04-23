package de.oninek.trainmate.api.dto;

import java.io.Serializable;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String displayName,
        BodyMeasurementResponse bodyComposition
) implements Serializable {
}
