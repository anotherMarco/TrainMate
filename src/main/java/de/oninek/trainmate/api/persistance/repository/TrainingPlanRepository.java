package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.TrainingPlanNotFoundException;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;

public interface TrainingPlanRepository extends TrainMateRepository<TrainingPlanEntity>{
    default TrainingPlanEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new TrainingPlanNotFoundException(id));
    }

}
