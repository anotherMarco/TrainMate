package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("exercise")
public interface ExerciseController {

    @Operation(summary = "Create exercise")
    @ApiResponse(responseCode = "201", description = "Exercise succesfully created",
            headers = {@Header(name = HttpHeaders.LOCATION, description = "The uri where the created resource can be found")},
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
    )
    @PostMapping
    ResponseEntity<ExerciseResponse> create(@RequestBody CreateExerciseRequest request);
}
