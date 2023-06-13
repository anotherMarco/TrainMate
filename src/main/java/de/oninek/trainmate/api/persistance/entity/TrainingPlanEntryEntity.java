package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "training_plan_entries")
public class TrainingPlanEntryEntity extends BaseEntity{

    private int ordinalNumber;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private ExerciseEntity exercise;
    @Embedded
    private RepetitionRange repetitions;
    private int sets;
    private Integer weight;
    private Integer seconds;

    @ManyToOne
    @JoinColumn(name = "training_plan_entity_id")
    private TrainingPlanEntity trainingPlanEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrainingPlanEntryEntity that = (TrainingPlanEntryEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
