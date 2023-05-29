package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "TrainingPlans")
@RequestMapping("training-plans")
public interface TrainingPlanController {

    @Operation(summary = "Create a training plan", operationId = "createTrainingPlan")
    @ApiResponse(responseCode = "201", description = "Training Plan successfully created",
            headers = {@Header(name = LOCATION, description = "The uri of the created resource")},
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TrainingPlanResponse.class))
    )
    @PostMapping
    ResponseEntity<TrainingPlanResponse> create(TrainingPlanRequest request);
}
