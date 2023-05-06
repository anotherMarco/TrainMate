package de.oninek.trainmate.api.dto;

import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;

import java.util.*;

public record AddClaimedMusclesRequest(MuscleIntensity intensity, Long claimedMuscleId) {
}
