package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.repository.ExerciseRepository;
import de.oninek.trainmate.api.service.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;
    @Override
    public ExerciseResponse create(CreateExerciseRequest request) {
        ExerciseEntity entity = exerciseMapper.requestToEntity(request);
        ExerciseEntity saved = exerciseRepository.save(entity);
        return exerciseMapper.entityToResponse(saved);
    }
}
