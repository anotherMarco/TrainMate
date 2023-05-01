package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.MERGE;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "claimed_muscles")
public class ClaimedMuscleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private MuscleIntensity intensity;
    @ManyToOne(cascade = MERGE)
    @JoinColumn(name = "muscle_id")
    private MuscleEntity muscle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClaimedMuscleEntity that = (ClaimedMuscleEntity) o;

        if (intensity != that.intensity) return false;
        return muscle.getName().equals(that.muscle.getName());
    }

    @Override
    public int hashCode() {
        int result = intensity.hashCode();
        result = 31 * result + muscle.getName().hashCode();
        return result;
    }
}
