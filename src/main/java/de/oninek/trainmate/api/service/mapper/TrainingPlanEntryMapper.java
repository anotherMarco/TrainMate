package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.dto.TrainingPlanEntryResponse;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrainingPlanEntryMapper {

    TrainingPlanEntryEntity toEntity(TrainingPlanEntryRequest request);

    List<TrainingPlanEntryEntity> toEntityList(List<TrainingPlanEntryRequest> requests);

    TrainingPlanEntryResponse toResponse(TrainingPlanEntryEntity entity);

    List<TrainingPlanEntryResponse> toResponseList(List<TrainingPlanEntryEntity> entities);
}
