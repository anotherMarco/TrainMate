package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.dto.TrainingPlanRequest;
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

    public TrainingPlanRequest buildRequest() {
        var requests = trainingPlanEntryBuilders.stream().map(TrainingPlanEntryTestDataBuilder::buildRequest).toList();
        return new TrainingPlanRequest(name, requests);
    }

    public TrainingPlanTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TrainingPlanTestDataBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TrainingPlanTestDataBuilder addEntry(TrainingPlanEntryTestDataBuilder entryBuilder) {
        trainingPlanEntryBuilders.add(entryBuilder);
        return this;
    }
}
