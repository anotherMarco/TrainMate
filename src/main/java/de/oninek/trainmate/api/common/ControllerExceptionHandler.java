package de.oninek.trainmate.api.common;

import de.oninek.trainmate.api.exceptions.BodyMeasurementNotFoundException;
import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> userNotFound(UserNotFoundException unfe) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(NOT_FOUND);
        problemDetail.setTitle("User not found");
        problemDetail.setDetail(unfe.getMessage());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler
    public ResponseEntity<?> measurementNotFound(BodyMeasurementNotFoundException bmnfe) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(NOT_FOUND);
        problemDetail.setTitle("Measurement not found");
        problemDetail.setDetail(bmnfe.getMessage());

        return ResponseEntity.of(problemDetail).build();
    }

}
