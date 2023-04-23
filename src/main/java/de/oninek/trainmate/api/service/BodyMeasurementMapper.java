package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.persistance.user.BodyMeasurementEntity;

public interface BodyMeasurementMapper {

    BodyMeasurementResponse entityToResponse(BodyMeasurementEntity entity);
}
