package de.oninek.trainmate.api;

import de.oninek.trainmate.api.testutil.MuscleBuilder;
import de.oninek.trainmate.api.persistance.entity.MuscleGroupEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MuscleGroupBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private LocalDateTime updatedAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private String name = "Abs";
    private List<MuscleBuilder> muscles = new ArrayList<>();
    public MuscleGroupEntity buildEntity() {
        MuscleGroupEntity muscleGroupEntity = new MuscleGroupEntity();
        muscleGroupEntity.setId(id);
        muscleGroupEntity.setName(name);
        muscleGroupEntity.setCreatedAt(createdAt);
        muscleGroupEntity.setUpdatedAt(updatedAt);
        for (MuscleBuilder muscle : muscles) {
            muscleGroupEntity.getMuscles().add(muscle.buildEntity());
        }
        return muscleGroupEntity;
    }

    public MuscleGroupBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public MuscleGroupBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public MuscleGroupBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public MuscleGroupBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MuscleGroupBuilder addMuscle(MuscleBuilder builder) {
        this.muscles.add(builder);
        return this;
    }
}
