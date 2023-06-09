package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.persistance.entity.BodyMeasurementEntity;

import java.time.LocalDateTime;

public class BodyMeasurementBuilder {

    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private LocalDateTime updatedAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private Double fatWeight = 20.0;
    private LocalDateTime measuredAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private Double weight = 90.0;
    private Double skeletalMuscleWeight = 20.0;
    private UserBuilder userBuilder = null;


   public BodyMeasurementEntity buildEntity() {
        BodyMeasurementEntity bodyMeasurementEntity = new BodyMeasurementEntity();
        bodyMeasurementEntity.setId(id);
        bodyMeasurementEntity.setCreatedAt(createdAt);
        bodyMeasurementEntity.setUpdatedAt(updatedAt);
        bodyMeasurementEntity.setFatMassWeight(fatWeight);
        bodyMeasurementEntity.setMeasuredAt(measuredAt);
        bodyMeasurementEntity.setWeight(weight);
        bodyMeasurementEntity.setSkeletalMuscleWeight(skeletalMuscleWeight);
        if (userBuilder != null) bodyMeasurementEntity.setUserEntity(userBuilder.buildEntity());

       return bodyMeasurementEntity;
    }

    public CreateBodyMeasurementRequest buildCreateRequest() {
       return new CreateBodyMeasurementRequest(weight, fatWeight, skeletalMuscleWeight, measuredAt);
    }

    public BodyMeasurementResponse buildResponse() {
        return new BodyMeasurementResponse(id, weight, fatWeight, skeletalMuscleWeight, measuredAt);
    }

    public BodyMeasurementBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public BodyMeasurementBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public BodyMeasurementBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public BodyMeasurementBuilder setFatWeight(Double fatWeight) {
        this.fatWeight = fatWeight;
        return this;
    }

    public BodyMeasurementBuilder setMeasuredAt(LocalDateTime measuredAt) {
        this.measuredAt = measuredAt;
        return this;
    }

    public BodyMeasurementBuilder setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public BodyMeasurementBuilder setSkeletalMuscleWeight(Double skeletalMuscleWeight) {
        this.skeletalMuscleWeight = skeletalMuscleWeight;
        return this;
    }

    public BodyMeasurementBuilder setUserBuilder(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
        return this;
    }
}
