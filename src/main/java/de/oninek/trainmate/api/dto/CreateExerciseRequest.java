package de.oninek.trainmate.api.dto;

import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public record CreateExerciseRequest(String name, HashMap<MuscleIntensity, Long> claimedMuscles, Set<Long> equipmentIds) implements Serializable {
}
