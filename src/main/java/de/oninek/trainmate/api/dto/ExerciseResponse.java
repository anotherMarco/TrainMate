package de.oninek.trainmate.api.dto;

import java.util.Set;

public record ExerciseResponse(Long id,
                               String name,
                               Set<String> mainMuscles,
                               Set<String> supportedMuscles,
                               Set<String> equipments) {
}
