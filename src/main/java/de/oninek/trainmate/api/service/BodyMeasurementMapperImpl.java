package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
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

    @Override
    public BodyMeasurementEntity requestToEntity(CreateBodyMeasurementRequest request) {
        BodyMeasurementEntity entity = new BodyMeasurementEntity();
        entity.setWeight(request.weight());
        entity.setFatPercentage(request.fatPercentage());
        entity.setSkeletalMuscleWeight(request.skeletalMuscleWeight());
        entity.setFatMassWeight(request.fatMassWeight());
        entity.setMeasuredAt(request.measuredAt());
        return entity;
    }
}
