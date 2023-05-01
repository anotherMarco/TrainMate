package de.oninek.trainmate.api.exceptions;

public class BodyMeasurementNotFoundException extends ResourceNotFoundException {

    public BodyMeasurementNotFoundException(Long id) {
        super("Measurement", id);
    }
}
