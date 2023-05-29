package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingPlanControllerImpl implements TrainingPlanController {
    @Override
    public ResponseEntity<TrainingPlanResponse> create(TrainingPlanRequest request) {
        throw new RuntimeException("Not implemented");
    }
}
