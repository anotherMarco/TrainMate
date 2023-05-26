package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;
import org.springframework.stereotype.Component;

@Component
public class EquipmentMapperImpl implements EquipmentMapper {
    @Override
    public EquipmentResponse entityToResponse(EquipmentEntity entity) {
        return new EquipmentResponse(entity.getId(), entity.getName());
    }
}
