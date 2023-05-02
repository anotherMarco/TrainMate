package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.MuscleNotFoundException;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MuscleRepository extends TrainMateRepository<MuscleEntity> {

    default MuscleEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new MuscleNotFoundException(id));
    }

    Page<MuscleEntity> findAllByMuscleGroupId(Long muscleCroupId, Pageable pageable);
}
