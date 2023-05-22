package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "muscle-groups")
@RequestMapping("muscle-groups")
public interface MuscleGroupController {

    @PageableAsQueryParam
    @Operation(summary = "Find many", operationId = "findManyMuscleGroups")
    @GetMapping
    ResponseEntity<Page<MuscleGroupResponse>> findMany(@Parameter(hidden = true) Pageable pageable);
}
