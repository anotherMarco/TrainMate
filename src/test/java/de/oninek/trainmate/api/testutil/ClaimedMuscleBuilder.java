package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.persistance.entity.ClaimedMuscleEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;

import java.time.LocalDateTime;

import static de.oninek.trainmate.api.persistance.entity.MuscleIntensity.MAIN;

public class ClaimedMuscleBuilder {

    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private LocalDateTime updatedAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private MuscleBuilder muscleBuilder = new MuscleBuilder();
    private MuscleIntensity muscleIntensity = MAIN;

    public ClaimedMuscleBuilder setMuscleBuilder(MuscleBuilder muscleBuilder) {
        this.muscleBuilder = muscleBuilder;
        return this;
    }

    public ClaimedMuscleBuilder setMuscleIntensity(MuscleIntensity muscleIntensity) {
        this.muscleIntensity = muscleIntensity;
        return this;
    }

    public ClaimedMuscleBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ClaimedMuscleBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ClaimedMuscleBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public ClaimedMuscleBuilder setMuscleName(String muscleName) {
        this.muscleBuilder.setName(muscleName);
        return this;
    }

    public ClaimedMuscleEntity buildEntity() {
        ClaimedMuscleEntity claimedMuscleEntity = new ClaimedMuscleEntity();
        claimedMuscleEntity.setId(id);
        claimedMuscleEntity.setCreatedAt(createdAt);
        claimedMuscleEntity.setUpdatedAt(updatedAt);
        claimedMuscleEntity.setIntensity(muscleIntensity);
        claimedMuscleEntity.setMuscle(muscleBuilder.buildEntity());
        return claimedMuscleEntity;
    }

}
