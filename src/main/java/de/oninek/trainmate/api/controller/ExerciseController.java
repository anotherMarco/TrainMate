package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Exercises")
@RequestMapping("exercises")
public interface ExerciseController {

    @Operation(summary = "Create exercise")
    @ApiResponse(responseCode = "201", description = "Exercise successfully created",
            headers = {@Header(name = LOCATION, description = "The uri of the created resource")},
            content = @Content(mediaType = APPLICATION_JSON_VALUE)
    )
    @PostMapping
    ResponseEntity<ExerciseResponse> create(@RequestBody CreateExerciseRequest request);

    @Operation(summary = "Add claimed muscles")
    @PostMapping("claimed-muscles/{id}")
    ResponseEntity<ExerciseResponse> addClaimedMuscles(@PathVariable Long id, @RequestBody AddClaimedMusclesRequest request);
}
