package de.oninek.trainmate.api.dto;

import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;
import jakarta.validation.constraints.NotEmpty;

import java.util.*;

public record AddClaimedMusclesRequest(MuscleIntensity intensity, @NotEmpty List<Long> claimedMuscleIds) {
}
