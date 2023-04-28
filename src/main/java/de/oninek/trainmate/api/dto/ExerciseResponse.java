package de.oninek.trainmate.api.dto;

import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;

import java.util.HashMap;
import java.util.Set;

public record ExerciseResponse(Long id, String name, HashMap<MuscleIntensity, String> claimedMuscles, Set<String> equipments) {
}
