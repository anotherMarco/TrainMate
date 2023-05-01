package de.oninek.trainmate.api.dto;

import java.io.Serializable;

public record MuscleResponse(Long id, String name, Long muscleGroupId, String muscleGroupName) implements Serializable {
}
