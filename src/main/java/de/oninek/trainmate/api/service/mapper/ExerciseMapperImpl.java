package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ExerciseMapperImpl implements ExerciseMapper {
    @Override
    public ExerciseEntity requestToEntity(CreateExerciseRequest request) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setName(request.name());
        return exerciseEntity;
    }

    @Override
    public ExerciseResponse entityToResponse(ExerciseEntity entity) {
        HashMap<MuscleIntensity, String> intensityNameMap = new HashMap<>();
        entity.getClaimedMuscles().forEach((muscleIntensity, muscleEntity) -> {
            intensityNameMap.put(muscleIntensity, muscleEntity.getName());
        });
        Set<String> equipments = entity.getEquipments().stream().map(EquipmentEntity::getName).collect(Collectors.toSet());
        return new ExerciseResponse(entity.getId(), entity.getName(), intensityNameMap, equipments);
    }
}
