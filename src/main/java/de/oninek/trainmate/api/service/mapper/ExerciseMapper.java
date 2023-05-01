package de.oninek.trainmate.api.service.mapper;


import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;

public interface ExerciseMapper {

    ExerciseEntity requestToEntity(CreateExerciseRequest request);

    ExerciseResponse entityToResponse(ExerciseEntity entity);
}
