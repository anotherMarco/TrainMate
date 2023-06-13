package de.oninek.trainmate.api.testutil;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.persistance.entity.RepetitionRange;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;

public class TrainingPlanEntryTestDataBuilder {

    private Long id = 1L;
    private int ordinalNumber = 0;
    private ExerciseBuilder exerciseBuilder = null;
    private int repetitionMin = 8;
    private int repetitionMax = 12;

    private int sets = 3;
    private Integer weight = 80;
    private Integer seconds = null;
    private TrainingPlanTestDataBuilder trainingPlan = null;

    public TrainingPlanEntryTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setExerciseBuilder(ExerciseBuilder exerciseBuilder) {
        this.exerciseBuilder = exerciseBuilder;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setRepetitionMin(int repetitionMin) {
        this.repetitionMin = repetitionMin;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setRepetitionMax(int repetitionMax) {
        this.repetitionMax = repetitionMax;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setSets(int sets) {
        this.sets = sets;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setSeconds(Integer seconds) {
        this.seconds = seconds;
        return this;
    }

    public TrainingPlanEntryTestDataBuilder setTrainingPlan(TrainingPlanTestDataBuilder trainingPlan) {
        this.trainingPlan = trainingPlan;
        return this;
    }

    public TrainingPlanEntryEntity buildEntity() {
        TrainingPlanEntryEntity entity = new TrainingPlanEntryEntity();
        entity.setId(id);
        if (exerciseBuilder != null) entity.setExercise(exerciseBuilder.buildEntity());
        entity.setRepetitions(new RepetitionRange(repetitionMin, repetitionMax));
        entity.setSets(sets);
        entity.setSeconds(seconds);
        if (trainingPlan != null) entity.setTrainingPlanEntity(trainingPlan.buildEntity());
        return entity;
    }

    public TrainingPlanEntryRequest buildRequest() {

        return new TrainingPlanEntryRequest(ordinalNumber,
                exerciseBuilder != null ? exerciseBuilder.getId() : null,
                repetitionMin,
                repetitionMax,
                sets,
                weight,
                seconds);
    }
}
