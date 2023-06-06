package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;

import java.util.List;

public interface TrainingPlanEntryMapper {

    TrainingPlanEntryEntity toEntity(TrainingPlanEntryRequest request);

    List<TrainingPlanEntryEntity> toEntityList(List<TrainingPlanEntryRequest> requests);
}
