package de.oninek.trainmate.api.dto;

import java.util.List;

public record TrainingPlanResponse(long id, String name, List<TrainingPlanEntryResponse> entries) {
}
