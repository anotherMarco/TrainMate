package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "exercises")
public class ExerciseEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany
    @MapKeyEnumerated(EnumType.STRING)
    private HashMap<MuscleIntensity, MuscleEntity> claimedMuscles;

    @ManyToMany
    @JoinTable(name = "exercises_equipments",
            joinColumns = @JoinColumn(name = "exercise_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "equipments_id"))
    private Set<EquipmentEntity> equipments = new LinkedHashSet<>();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + getId() + ", " +
               "createdAt = " + getCreatedAt() + ", " +
               "updatedAt = " + getUpdatedAt() + ", " +
               "name = " + getName() + ")";
    }
}
