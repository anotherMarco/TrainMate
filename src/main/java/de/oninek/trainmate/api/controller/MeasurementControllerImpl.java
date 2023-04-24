package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.service.BodyMeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
public class MeasurementControllerImpl implements MeasurementController {

    private final BodyMeasurementService service;

    @Override
    public ResponseEntity<BodyMeasurementResponse> save(long userId, CreateBodyMeasurementRequest request) {
        BodyMeasurementResponse response = service.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
