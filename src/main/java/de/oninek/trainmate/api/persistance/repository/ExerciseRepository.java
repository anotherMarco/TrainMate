package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.ExerciseNotFoundException;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;

public interface ExerciseRepository extends TrainMateRepository<ExerciseEntity> {

    default ExerciseEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new ExerciseNotFoundException(id));
    }
}
