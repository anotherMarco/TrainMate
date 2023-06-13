package de.oninek.trainmate.api.exceptions;

public class TrainingPlanNotFoundException extends ResourceNotFoundException{
    public TrainingPlanNotFoundException(Long id) {
        super("TrainingPlan", id);
    }
}
