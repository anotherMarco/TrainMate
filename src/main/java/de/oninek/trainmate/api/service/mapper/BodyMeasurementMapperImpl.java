package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.persistance.entity.BodyMeasurementEntity;
import org.springframework.stereotype.Component;

@Component
public class BodyMeasurementMapperImpl implements BodyMeasurementMapper {
    @Override
    public BodyMeasurementResponse entityToResponse(BodyMeasurementEntity entity) {
      return new BodyMeasurementResponse(entity.getId(),
                entity.getWeight(),
                entity.getFatMassWeight(),
                entity.getSkeletalMuscleWeight(),
                entity.getMeasuredAt());
    }

    @Override
    public BodyMeasurementEntity requestToEntity(CreateBodyMeasurementRequest request) {
        BodyMeasurementEntity entity = new BodyMeasurementEntity();
        entity.setWeight(request.weight());
        entity.setFatMassWeight(request.fatMassWeight());
        entity.setSkeletalMuscleWeight(request.skeletalMuscleWeight());
        entity.setMeasuredAt(request.measuredAt());
        return entity;
    }
}
