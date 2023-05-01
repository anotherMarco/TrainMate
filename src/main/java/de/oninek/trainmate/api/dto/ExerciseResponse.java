package de.oninek.trainmate.api.dto;

import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;

import java.util.Map;
import java.util.Set;

public record ExerciseResponse(Long id, String name, Map<MuscleIntensity, Set<String>> claimedMuscles,
                               Set<String> equipments) {
}
