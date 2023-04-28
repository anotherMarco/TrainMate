package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.BaseEntity;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ExerciseBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private LocalDateTime updatedAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private String name = "Bench Press";
    private HashMap<MuscleIntensity, MuscleBuilder> claimedMuscles = new HashMap<>();
    private List<EquipmentBuilder> equipments = new ArrayList<>();

    public ExerciseEntity buildEntity() {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setName(name);
        claimedMuscles.forEach((muscleIntensity, muscleBuilder) -> {
            exerciseEntity.getClaimedMuscles().put(muscleIntensity, muscleBuilder.buildEntity());
        });
        for (EquipmentBuilder equipment : equipments) {
            exerciseEntity.getEquipments().add(equipment.buildEntity());
        }
        return exerciseEntity;
    }

    public CreateExerciseRequest buildCreateRequest() {
        HashMap<MuscleIntensity, Long> intensityLongHashMap = new HashMap<>();
        claimedMuscles.forEach((muscleIntensity, muscleBuilder) -> {
            intensityLongHashMap.put(muscleIntensity, muscleBuilder.buildEntity().getId());
        });

        Set<Long> equipmentIds = equipments.stream()
                .map(EquipmentBuilder::buildEntity)
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
        return new CreateExerciseRequest(name, intensityLongHashMap, equipmentIds);
    }

    public ExerciseResponse buildResponse() {
        HashMap<MuscleIntensity, String> hashMap = new HashMap<>();
        claimedMuscles.forEach((muscleIntensity, muscleBuilder) -> {
            hashMap.put(muscleIntensity, muscleBuilder.buildEntity().getName());
        });
        Set<String> equipments = this.equipments.stream()
                .map(EquipmentBuilder::buildEntity)
                .map(EquipmentEntity::getName)
                .collect(Collectors.toSet());
        return new ExerciseResponse(id, name, hashMap, equipments);
    }

    public ExerciseBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ExerciseBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ExerciseBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public ExerciseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ExerciseBuilder setClaimedMuscles(MuscleIntensity intensity, MuscleBuilder builder) {
        this.claimedMuscles.put(intensity, builder);
        return this;
    }

    public ExerciseBuilder addEquipment(EquipmentBuilder equipment) {
        this.equipments.add(equipment);
        return this;
    }
}
