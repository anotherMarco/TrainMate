package de.oninek.trainmate.api.exceptions;

public class BodyMeasurementNotFoundException extends RuntimeException {

    public BodyMeasurementNotFoundException() {
    }

    public BodyMeasurementNotFoundException(String message) {
        super(message);
    }

    public BodyMeasurementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BodyMeasurementNotFoundException(Throwable cause) {
        super(cause);
    }

    public BodyMeasurementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
