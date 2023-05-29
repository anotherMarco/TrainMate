package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.*;
import de.oninek.trainmate.api.persistance.entity.ClaimedMuscleEntity;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import de.oninek.trainmate.api.persistance.repository.EquipmentRepository;
import de.oninek.trainmate.api.persistance.repository.ExerciseRepository;
import de.oninek.trainmate.api.persistance.repository.MuscleRepository;
import de.oninek.trainmate.api.service.mapper.EquipmentMapper;
import de.oninek.trainmate.api.service.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.oninek.trainmate.api.persistance.repository.ExerciseRepository.*;

@RequiredArgsConstructor
@Service
class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final MuscleRepository muscleRepository;
    private final EquipmentRepository equipmentRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public ExerciseResponse create(CreateExerciseRequest request) {
        ExerciseEntity entity = exerciseMapper.requestToEntity(request);
        ExerciseEntity saved = exerciseRepository.save(entity);
        return exerciseMapper.entityToResponse(saved);
    }

    @Override
    public ExerciseResponse addClaimedMuscle(Long id, AddClaimedMusclesRequest request) {
        ExerciseEntity exercise = exerciseRepository.findByIdOrThrow(id);
        var muscles = muscleRepository.findAllById(request.claimedMuscleIds());
        for (MuscleEntity muscle : muscles) {
            ClaimedMuscleEntity claimedMuscleEntity = new ClaimedMuscleEntity();
            claimedMuscleEntity.setMuscle(muscle);
            claimedMuscleEntity.setIntensity(request.intensity());
            exercise.addClaimedMuscle(claimedMuscleEntity);
        }
        ExerciseEntity saved = exerciseRepository.save(exercise);
        return exerciseMapper.entityToResponse(saved);
    }

    @Override
    public ExerciseResponse addEquipment(Long id, AddEquipmentsRequest request) {
        ExerciseEntity exercise = exerciseRepository.findByIdOrThrow(id);
        Iterable<EquipmentEntity> equipments = equipmentRepository.findAllById(request.ids());
        for (EquipmentEntity equipment : equipments) {
            exercise.addEquipment(equipment);
        }
        exerciseRepository.save(exercise);
        return exerciseMapper.entityToResponse(exercise);
    }

    @Override
    public Page<ExerciseResponse> findMany(List<Long> claimedMuscleGroupIds,
                                           List<Long> mainMuscleIds,
                                           List<Long> supportMuscleIds,
                                           Pageable pageable) {
        Specification<ExerciseEntity> specification = isInMainMuscles(mainMuscleIds)
                .and(isInSupportedMuscles(supportMuscleIds))
                .and(isInMuscleGroup(claimedMuscleGroupIds));
        return exerciseRepository.findAll(specification, pageable)
                .map(exerciseMapper::entityToResponse);
    }
}
