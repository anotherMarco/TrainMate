package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
        ExerciseResponse exerciseResponse = exerciseService.addClaimedMuscles(id, request);
        return ResponseEntity.ok(exerciseResponse);
    }
}
