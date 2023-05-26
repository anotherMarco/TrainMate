package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.MuscleResponse;
import de.oninek.trainmate.api.service.MuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class MuscleControllerImpl implements MuscleController {

    private final MuscleService muscleService;
    @Override
    public ResponseEntity<Page<MuscleResponse>> findMany(List<Long> muscleGroupIds, Pageable pageable) {
        Page<MuscleResponse> muscles = muscleService.findMany(muscleGroupIds, pageable);
        return ResponseEntity.ok(muscles);
    }
}
