package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import de.oninek.trainmate.api.service.MuscleGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class MuscleGroupControllerImpl implements MuscleGroupController {

    private final MuscleGroupService muscleGroupService;
    @Override
    public ResponseEntity<Page<MuscleGroupResponse>> findMany(Pageable pageable) {
        return ResponseEntity.ok(muscleGroupService.findMany(pageable));
    }
}
