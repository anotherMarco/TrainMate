package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.MuscleResponse;
import de.oninek.trainmate.api.service.MuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MuscleControllerImpl implements MuscleController {

    private final MuscleService muscleService;
    @Override
    public ResponseEntity<Page<MuscleResponse>> findMany(Long muscleGroupId, Pageable pageable) {
        Page<MuscleResponse> muscles = muscleService.findMany(muscleGroupId, pageable);
        return ResponseEntity.ok(muscles);
    }
}
