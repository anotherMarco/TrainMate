package de.oninek.trainmate.api.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " with id: " + id + " can't be found");
    }
}
