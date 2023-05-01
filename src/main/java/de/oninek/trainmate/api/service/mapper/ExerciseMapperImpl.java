package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.ClaimedMuscleEntity;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;
import org.springframework.stereotype.Component;

import java.util.Map;
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
        Map<MuscleIntensity, Set<String>> muscleIntensitySetMap = entity.getClaimedMuscles().stream()
                .collect(Collectors.groupingBy(ClaimedMuscleEntity::getIntensity, Collectors.mapping(claimedMuscleEntity -> claimedMuscleEntity.getMuscle().getName(), Collectors.toSet())));
        Set<String> equipments = entity.getEquipments().stream().map(EquipmentEntity::getName).collect(Collectors.toSet());
        return new ExerciseResponse(entity.getId(), entity.getName(), muscleIntensitySetMap, equipments);
    }
}
