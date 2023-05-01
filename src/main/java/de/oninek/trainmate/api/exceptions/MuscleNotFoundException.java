package de.oninek.trainmate.api.exceptions;

public class MuscleNotFoundException extends ResourceNotFoundException{
    public MuscleNotFoundException(Long id) {
        super("Muscle", id);
    }
}
