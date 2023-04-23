package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.persistance.user.BodyMeasurementEntity;
import org.springframework.stereotype.Component;

@Component
public class BodyMeasurementMapperImpl implements BodyMeasurementMapper {
    @Override
    public BodyMeasurementResponse entityToResponse(BodyMeasurementEntity entity) {
      return new BodyMeasurementResponse(entity.getId(),
                entity.getWeight(),
                entity.getFatPercentage(),
                entity.getSkeletalMuscleWeight(),
                entity.getFatMassWeight(),
                entity.getMeasuredAt());
    }
}
