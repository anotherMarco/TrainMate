package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.persistance.entity.BodyMeasurementEntity;

public interface BodyMeasurementMapper {

    BodyMeasurementResponse entityToResponse(BodyMeasurementEntity entity);

    BodyMeasurementEntity requestToEntity(CreateBodyMeasurementRequest request);
}
