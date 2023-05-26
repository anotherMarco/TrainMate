package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.MuscleResponse;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import org.springframework.stereotype.Component;

@Component
class MuscleMapperImpl implements MuscleMapper {
    @Override
    public MuscleResponse entityToResponse(MuscleEntity entity) {
        return new MuscleResponse(entity.getId(),
                entity.getName(),
                entity.getMuscleGroup().getId(),
                entity.getMuscleGroup().getName());
    }
}
