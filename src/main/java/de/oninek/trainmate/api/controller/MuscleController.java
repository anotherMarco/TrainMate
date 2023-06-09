package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.MuscleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "muscles")
@RequestMapping("muscles")
public interface MuscleController {

    @PageableAsQueryParam
    @Operation(summary = "find many", operationId = "findManyMuscles")
    @GetMapping
    ResponseEntity<Page<MuscleResponse>> findMany(
            @RequestParam(name = "muscle-group-id", required = false) List<Long> muscleGroupIds,
            @Parameter(hidden = true)
            Pageable pageable);
}
