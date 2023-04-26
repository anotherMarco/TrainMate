package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Measurements")
@RequestMapping("users/{user-id}/measurements")
public interface MeasurementController {

    @PostMapping
    ResponseEntity<BodyMeasurementResponse> save(@PathVariable(value = "user-id") long userId,
                                                 @RequestBody CreateBodyMeasurementRequest request);
}
