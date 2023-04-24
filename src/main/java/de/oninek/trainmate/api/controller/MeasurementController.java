package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("{user-id}/measurements")
public interface MeasurementController {

    @GetMapping
    ResponseEntity<BodyMeasurementResponse> save(@PathVariable(value = "user-id") long userId,
                                                 @RequestBody CreateBodyMeasurementRequest request);
}
