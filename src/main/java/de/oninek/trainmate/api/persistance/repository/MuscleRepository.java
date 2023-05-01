package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.MuscleNotFoundException;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;

public interface MuscleRepository extends TrainMateRepository<MuscleEntity> {

    default MuscleEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new MuscleNotFoundException(id));
    }
}
