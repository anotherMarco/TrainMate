package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.MuscleNotFoundException;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MuscleRepository extends TrainMateRepository<MuscleEntity> {
    Page<MuscleEntity> findAllByMuscleGroupId(Pageable pageable, Long muscleGroupId);

    default Page<MuscleEntity> findAllByMuscleGroupIdOrFindAll(Pageable pageable, Long muscleGroupId) {
        return Optional.ofNullable(muscleGroupId)
                .map(id -> findAllByMuscleGroupId(pageable, id))
                .orElseGet(() -> findAll(pageable));
    }

    default MuscleEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new MuscleNotFoundException(id));
    }

}
