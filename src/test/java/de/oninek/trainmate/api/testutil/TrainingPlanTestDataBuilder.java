package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;

import java.util.ArrayList;
import java.util.List;

public class TrainingPlanTestDataBuilder {

    private Long id = 1L;
    private String name = "Legs";
    private List<TrainingPlanEntryTestDataBuilder> trainingPlanEntryBuilders = new ArrayList<>();
    public TrainingPlanEntity buildEntity() {
        TrainingPlanEntity entity = new TrainingPlanEntity();
        entity.setId(id);
        entity.setName(name);
        var entries = trainingPlanEntryBuilders.stream()
                .map(TrainingPlanEntryTestDataBuilder::buildEntity)
                .toList();
        entity.setEntries(entries);
        return entity;
    }
}
