package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExerciseControllerImpl implements ExerciseController {

    private final ExerciseService exerciseService;
    @Override
    public ResponseEntity<ExerciseResponse> create(CreateExerciseRequest request) {
        ExerciseResponse response = exerciseService.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<ExerciseResponse> addClaimedMuscles(Long id, AddClaimedMusclesRequest request) {
        ExerciseResponse exerciseResponse = exerciseService.addClaimedMuscle(id, request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/claimed-muscles").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(exerciseResponse);
    }

    @Override
    public ResponseEntity<Page<ExerciseResponse>> findMany(List<Long> claimedMuscleGroupIds,
                                                           List<Long> mainMuscleIds,
                                                           List<Long> supportMuscleIds,
                                                           Pageable pageable) {
        Page<ExerciseResponse> response = exerciseService.findMany(claimedMuscleGroupIds, mainMuscleIds, supportMuscleIds, pageable);
        return ResponseEntity.ok(response);
    }


}
