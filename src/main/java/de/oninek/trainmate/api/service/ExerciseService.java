package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.AddEquipmentsRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExerciseService {

    ExerciseResponse create(CreateExerciseRequest request);

    ExerciseResponse addClaimedMuscle(Long id, AddClaimedMusclesRequest request);

    ExerciseResponse addEquipment(Long id, AddEquipmentsRequest request);

    Page<ExerciseResponse> findMany(List<Long> claimedMuscleGroupIds,
                                    List<Long> mainMuscleIds,
                                    List<Long> supportMuscleIds,
                                    Pageable pageable);
}
