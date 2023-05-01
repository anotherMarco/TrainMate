package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.ClaimedMuscleEntity;
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
    private List<ClaimedMuscleBuilder> claimedMuscles = new ArrayList<>();
    private List<EquipmentBuilder> equipments = new ArrayList<>();

    public ExerciseEntity buildEntity() {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setName(name);
        for (ClaimedMuscleBuilder claimedMuscle : claimedMuscles) {
            exerciseEntity.getClaimedMuscles().add(claimedMuscle.buildEntity());
        }
        for (EquipmentBuilder equipment : equipments) {
            exerciseEntity.getEquipments().add(equipment.buildEntity());
        }
        return exerciseEntity;
    }

    public CreateExerciseRequest buildCreateRequest() {
        return new CreateExerciseRequest(name);
    }

    public ExerciseResponse buildResponse() {
        Map<MuscleIntensity, Set<String>> claimedMuscles = this.claimedMuscles.stream().map(ClaimedMuscleBuilder::buildEntity)
                .collect(Collectors.groupingBy(
                        ClaimedMuscleEntity::getIntensity,
                        Collectors.mapping(claimedMuscleEntity -> claimedMuscleEntity.getMuscle().getName(),
                                Collectors.toSet())));

        Set<String> equipments = this.equipments.stream()
                .map(EquipmentBuilder::buildEntity)
                .map(EquipmentEntity::getName)
                .collect(Collectors.toSet());
        return new ExerciseResponse(id, name, claimedMuscles, equipments);
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

    public ExerciseBuilder addClaimedMuscle(ClaimedMuscleBuilder claimedMuscleBuilder) {
        this.claimedMuscles.add(claimedMuscleBuilder);
        return this;
    }

    public ExerciseBuilder addEquipment(EquipmentBuilder equipment) {
        this.equipments.add(equipment);
        return this;
    }
}
