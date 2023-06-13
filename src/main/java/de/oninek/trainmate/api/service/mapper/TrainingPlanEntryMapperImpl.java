package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.dto.TrainingPlanEntryResponse;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.RepetitionRange;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;

import java.util.List;

public class TrainingPlanEntryMapperImpl implements TrainingPlanEntryMapper {
    @Override
    public TrainingPlanEntryEntity toEntity(TrainingPlanEntryRequest request) {
        TrainingPlanEntryEntity entity = new TrainingPlanEntryEntity();
        entity.setOrdinalNumber(request.ordinalNumber());
        RepetitionRange repetitionRange = new RepetitionRange(request.minRepetitions(), request.maxRepetitions());
        entity.setRepetitions(repetitionRange);
        entity.setSets(request.sets());
        entity.setWeight(request.weight());
        entity.setSeconds(request.seconds());
        return entity;
    }

    @Override
    public List<TrainingPlanEntryEntity> toEntityList(List<TrainingPlanEntryRequest> requests) {
        return requests.stream().map(this::toEntity).toList();
    }

    @Override
    public TrainingPlanEntryResponse toResponse(TrainingPlanEntryEntity entity) {
        RepetitionRange repetitions = entity.getRepetitions();
        ExerciseEntity exercise = entity.getExercise();
        return new TrainingPlanEntryResponse(entity.getId(),
                entity.getOrdinalNumber(),
                exercise.getId(),
                exercise.getName(),
                repetitions.getMin(),
                repetitions.getMax(),
                entity.getSets(),
                entity.getWeight(),
                entity.getSeconds());
    }
}
