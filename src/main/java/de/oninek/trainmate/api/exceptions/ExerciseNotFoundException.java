package de.oninek.trainmate.api.exceptions;

public class ExerciseNotFoundException extends ResourceNotFoundException{
    public ExerciseNotFoundException(Long id) {
        super("Exercise", id);
    }
}
