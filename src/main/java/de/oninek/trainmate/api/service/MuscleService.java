package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.MuscleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MuscleService {

    Page<MuscleResponse> findMany(List<Long> muscleGroupIds, Pageable pageable);
}
