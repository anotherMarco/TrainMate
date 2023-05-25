package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import de.oninek.trainmate.api.persistance.entity.MuscleGroupEntity;
import org.springframework.stereotype.Component;

@Component
class MuscleGroupMapperImpl implements MuscleGroupMapper {
    @Override
    public MuscleGroupResponse entityToResponse(MuscleGroupEntity entity) {
        return new MuscleGroupResponse(entity.getId(), entity.getName());
    }
}
