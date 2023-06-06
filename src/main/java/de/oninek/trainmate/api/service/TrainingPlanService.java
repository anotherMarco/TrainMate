package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainingPlanService {
    Page<TrainingPlanResponse> findMany(Pageable pageable);

    TrainingPlanResponse create(TrainingPlanRequest request);
}
