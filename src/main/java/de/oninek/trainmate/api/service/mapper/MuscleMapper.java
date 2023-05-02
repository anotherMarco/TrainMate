package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.MuscleResponse;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;

public interface MuscleMapper {
    MuscleResponse entityToResponse(MuscleEntity entity);
}
