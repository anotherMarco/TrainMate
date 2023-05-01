package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import de.oninek.trainmate.api.MuscleGroupBuilder;

import java.time.LocalDateTime;

public class MuscleBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private LocalDateTime updatedAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private String name;
    private MuscleGroupBuilder muscleGroup;

    public MuscleEntity buildEntity() {
        MuscleEntity muscleEntity = new MuscleEntity();
        muscleEntity.setId(id);
        muscleEntity.setCreatedAt(createdAt);
        muscleEntity.setUpdatedAt(updatedAt);
        muscleEntity.setName(name);
        if (muscleGroup != null) muscleEntity.setMuscleGroup(muscleGroup.buildEntity());
        return muscleEntity;
    }

    public MuscleBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public MuscleBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public MuscleBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public MuscleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MuscleBuilder setMuscleGroup(MuscleGroupBuilder muscleGroup) {
        this.muscleGroup = muscleGroup;
        return this;
    }
}
