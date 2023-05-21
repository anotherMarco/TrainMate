package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import de.oninek.trainmate.api.persistance.entity.MuscleGroupEntity;

public interface MuscleGroupMapper {

    MuscleGroupResponse entityToResponse(MuscleGroupEntity entity);
}
