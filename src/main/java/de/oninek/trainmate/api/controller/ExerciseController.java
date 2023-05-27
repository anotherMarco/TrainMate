package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.AddEquipmentsRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Exercises")
@RequestMapping("exercises")
public interface ExerciseController {

    @Operation(summary = "Create exercise", operationId = "createExercise")
    @ApiResponse(responseCode = "201", description = "Exercise successfully created",
            headers = {@Header(name = LOCATION, description = "The uri of the created resource")},
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExerciseResponse.class))
    )
    @PostMapping
    ResponseEntity<ExerciseResponse> create(@RequestBody CreateExerciseRequest request);

    @Operation(summary = "Add claimed muscles", operationId = "addClaimedMuscles")
    @PostMapping("{id}/claimed-muscles")
    ResponseEntity<ExerciseResponse> addClaimedMuscles(@PathVariable Long id, @RequestBody AddClaimedMusclesRequest request);

    @Operation(summary = "Add equipments", operationId = "addEquipments")
    @PostMapping("{id}/equipments")
    ResponseEntity<ExerciseResponse> addEquipments(@PathVariable Long id, @RequestBody AddEquipmentsRequest request);

    @PageableAsQueryParam
    @Operation(summary = "Find many", operationId = "findManyExercises")
    @GetMapping
    ResponseEntity<Page<ExerciseResponse>> findMany(
            @RequestParam(name = "claimed-muscle-groups", required = false) List<Long> claimedMuscleGroupIds,
            @RequestParam(name = "main-muscles", required = false) List<Long> mainMuscleIds,
            @RequestParam(name = "support-muscles", required = false) List<Long> supportMuscleIds,
            @Parameter(hidden = true) Pageable pageable);
}
