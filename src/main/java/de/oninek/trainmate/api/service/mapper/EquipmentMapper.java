package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;

public interface EquipmentMapper {

    EquipmentResponse entityToResponse(EquipmentEntity entity);

}
