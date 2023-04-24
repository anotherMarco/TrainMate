package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;

public interface BodyMeasurementService {
    BodyMeasurementResponse save(long userId, CreateBodyMeasurementRequest request);
}
