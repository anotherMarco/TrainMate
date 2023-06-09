package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "body_measurement")
public class BodyMeasurementEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userEntity;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "skeletal_muscle_weight")
    private Double skeletalMuscleWeight;

    @Column(name = "fat_mass_weight")
    private Double fatMassWeight;

    @Column(name = "measured_at", nullable = false)
    private LocalDateTime measuredAt;

    public void setUserEntity(UserEntity user) {
        if (user.getBodyMeasurements().add(this)) {
            userEntity = user;
        }
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + getId() + ", " +
               "createdAt = " + getCreatedAt() + ", " +
               "updatedAt = " + getUpdatedAt() + ")";
    }
}
