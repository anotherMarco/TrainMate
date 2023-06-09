package de.oninek.trainmate.api.dto;

public record TrainingPlanEntryResponse(
        long id,
        int ordinalNumber,
        long exerciseId,
        String exerciseName,
        Integer minRepetitions,
        Integer maxRepetitions,
        Integer weight,
        Integer seconds
) {
}
