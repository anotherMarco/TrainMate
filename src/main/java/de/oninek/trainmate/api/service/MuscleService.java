package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.MuscleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MuscleService {

    Page<MuscleResponse> findMany(Long muscleGroupId, Pageable pageable);
}
