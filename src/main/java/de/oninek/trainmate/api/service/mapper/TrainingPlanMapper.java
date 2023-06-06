package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;

public interface TrainingPlanMapper {

    TrainingPlanEntity toEntity(TrainingPlanRequest request);

    TrainingPlanResponse toResponse(TrainingPlanEntity entity);
}
