package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.MuscleNotFoundException;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MuscleRepository extends TrainMateRepository<MuscleEntity> {
    Page<MuscleEntity> findAllByMuscleGroupIdIn(Pageable pageable, List<Long> muscleGroupIds);

    default MuscleEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new MuscleNotFoundException(id));
    }

}
