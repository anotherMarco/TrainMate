package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;

public interface ExerciseService {

    ExerciseResponse create(CreateExerciseRequest request);

    ExerciseResponse addClaimedMuscle(Long id, AddClaimedMusclesRequest request);
}
