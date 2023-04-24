package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Measurements")
@RequestMapping("{user-id}/measurements")
public interface MeasurementController {

    @GetMapping
    @ApiResponse(responseCode = "404", description = "user not found")
    ResponseEntity<BodyMeasurementResponse> save(@PathVariable(value = "user-id") long userId,
                                                 @RequestBody CreateBodyMeasurementRequest request);
}
