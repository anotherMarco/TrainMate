package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.dto.TrainingPlanEntryResponse;
import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import de.oninek.trainmate.api.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class TrainingPlanControllerImpl implements TrainingPlanController {

    private final TrainingPlanService trainingPlanService;

    @Override
    public ResponseEntity<Page<TrainingPlanResponse>> findMany(Pageable pageable) {
        Page<TrainingPlanResponse> responses = trainingPlanService.findMany(pageable);
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<TrainingPlanEntryResponse> addEntry(TrainingPlanEntryRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<TrainingPlanResponse> create(TrainingPlanRequest request) {
        TrainingPlanResponse response = trainingPlanService.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
