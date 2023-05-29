package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "training_plans")
public class TrainingPlanEntity extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "trainingPlanEntity", orphanRemoval = true)
    @OrderColumn(name = "ordinalNumber")
    private List<TrainingPlanEntryEntity> entries = new ArrayList<>();
}
