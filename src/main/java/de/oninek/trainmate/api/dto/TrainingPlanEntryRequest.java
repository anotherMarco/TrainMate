package de.oninek.trainmate.api.dto;

public record TrainingPlanEntryRequest(
        int ordinalNumber,
        long exerciseId,
        Integer minRepetitions,
        Integer maxRepetitions,
        Integer weight,
        Integer seconds
) {

}
