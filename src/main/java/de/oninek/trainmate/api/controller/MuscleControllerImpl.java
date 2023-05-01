package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.MuscleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MuscleControllerImpl implements MuscleController {
    @Override
    public ResponseEntity<Page<MuscleResponse>> findMany(Long muscleGroupId, Pageable pageable) {
        return null;
    }
}
