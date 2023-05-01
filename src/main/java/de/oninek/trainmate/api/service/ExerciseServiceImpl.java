package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.ClaimedMuscleEntity;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;
import de.oninek.trainmate.api.persistance.repository.ExerciseRepository;
import de.oninek.trainmate.api.persistance.repository.MuscleRepository;
import de.oninek.trainmate.api.service.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final MuscleRepository muscleRepository;
    private final ExerciseMapper exerciseMapper;
    @Override
    public ExerciseResponse create(CreateExerciseRequest request) {
        ExerciseEntity entity = exerciseMapper.requestToEntity(request);
        ExerciseEntity saved = exerciseRepository.save(entity);
        return exerciseMapper.entityToResponse(saved);
    }

    @Override
    public ExerciseResponse addClaimedMuscles(Long id, AddClaimedMusclesRequest request) {
        ExerciseEntity exercise = exerciseRepository.findByIdOrThrow(id);
        for (MuscleIntensity muscleIntensity : request.claimedMuscles().keySet()) {
            //TODO throw exception if on ore more muscles not exists
            Set<Long> ids = request.claimedMuscles().get(muscleIntensity);
            Iterable<MuscleEntity> muscles = muscleRepository.findAllById(ids);
            for (MuscleEntity muscleEntity : muscles) {
                ClaimedMuscleEntity claimedMuscleEntity = new ClaimedMuscleEntity();
                claimedMuscleEntity.setMuscle(muscleEntity);
                claimedMuscleEntity.setIntensity(muscleIntensity);
                exercise.addClaimedMuscle(claimedMuscleEntity);
            }
        }
        ExerciseEntity saved = exerciseRepository.save(exercise);
        return exerciseMapper.entityToResponse(saved);
    }
}
