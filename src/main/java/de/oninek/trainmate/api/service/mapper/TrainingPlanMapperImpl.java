package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanEntryResponse;
import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TrainingPlanMapperImpl implements TrainingPlanMapper {

    private final TrainingPlanEntryMapper entryMapper;

    @Override
    public TrainingPlanEntity toEntity(TrainingPlanRequest request) {
        TrainingPlanEntity trainingPlanEntity = new TrainingPlanEntity();
        trainingPlanEntity.setName(request.name());
        List<TrainingPlanEntryEntity> entries = entryMapper.toEntityList(request.entries());
        trainingPlanEntity.setEntries(entries);
        return trainingPlanEntity;
    }

    @Override
    public TrainingPlanResponse toResponse(TrainingPlanEntity entity) {
        List<TrainingPlanEntryResponse> entries = entryMapper.toResponseList(entity.getEntries());

        return new TrainingPlanResponse(entity.getId(), entity.getName(), entries);
    }
}
