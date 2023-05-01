package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.MuscleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "muscles")
@RequestMapping("muscles")
public interface MuscleController {

    ResponseEntity<Page<MuscleResponse>> findMany(
            @RequestParam(name = "muscle-group-id", required = false) Long muscleGroupId,
            @RequestParam()
            Pageable pageable);
}
