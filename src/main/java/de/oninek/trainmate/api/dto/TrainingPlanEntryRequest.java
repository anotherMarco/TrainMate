package de.oninek.trainmate.api.dto;

public record TrainingPlanEntryRequest(
        int ordinalNumber,
        Long exerciseId,
        Integer minRepetitions,
        Integer maxRepetitions,
        Integer sets,
        Integer weight,
        Integer seconds
) {

}
