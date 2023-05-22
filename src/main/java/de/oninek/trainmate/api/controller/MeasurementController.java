package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Measurements")
@RequestMapping("users/{user-id}/measurements")
public interface MeasurementController {

    @Operation(summary = "Create measurement", operationId = "createMeasurement")
    @PostMapping
    ResponseEntity<BodyMeasurementResponse> create(@PathVariable(value = "user-id") long userId,
                                                   @RequestBody CreateBodyMeasurementRequest request);
}
