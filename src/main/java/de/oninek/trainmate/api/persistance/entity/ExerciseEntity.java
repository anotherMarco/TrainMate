package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import java.util.LinkedHashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.MERGE;

@Getter
@Setter
@Entity
@Table(name = "exercises")
@ComponentScan
public class ExerciseEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @ManyToMany(cascade = MERGE)
    @JoinTable(name = "exercises_claimed_muscles",
            joinColumns = @JoinColumn(name = "exercise_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "claimed_muscles_id"))
    private Set<ClaimedMuscleEntity> claimedMuscles = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "exercises_equipments",
            joinColumns = @JoinColumn(name = "exercise_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "equipments_id"))
    private Set<EquipmentEntity> equipments = new LinkedHashSet<>();

    public void addClaimedMuscle(ClaimedMuscleEntity claimedMuscle) {
        claimedMuscles.add(claimedMuscle);
    }

    public void addEquipment(EquipmentEntity equipment) {
        equipments.add(equipment);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + getId() + ", " +
               "createdAt = " + getCreatedAt() + ", " +
               "updatedAt = " + getUpdatedAt() + ", " +
               "name = " + getName() + ")";
    }
}
