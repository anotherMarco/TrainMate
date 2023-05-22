package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MuscleGroupService {

    public Page<MuscleGroupResponse> findMany(Pageable pageable);
}
