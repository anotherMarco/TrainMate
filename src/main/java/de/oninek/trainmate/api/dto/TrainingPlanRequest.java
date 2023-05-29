package de.oninek.trainmate.api.dto;

import java.util.List;

public record TrainingPlanRequest(String name, List<TrainingPlanEntryRequest> entries) {
}
