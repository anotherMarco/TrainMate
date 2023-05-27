package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.dto.AddEquipmentsRequest;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;

import java.time.LocalDateTime;
import java.util.List;

public class EquipmentBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private LocalDateTime updatedAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private String name = "barbell";

    public EquipmentEntity buildEntity() {
        EquipmentEntity equipmentEntity = new EquipmentEntity();
        equipmentEntity.setName(name);
        equipmentEntity.setId(id);
        equipmentEntity.setCreatedAt(createdAt);
        equipmentEntity.setUpdatedAt(updatedAt);
        return equipmentEntity;
    }

    public AddEquipmentsRequest buildRequest() {
       return new AddEquipmentsRequest(List.of(id));
    }

    public EquipmentBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public EquipmentBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public EquipmentBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public EquipmentBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
