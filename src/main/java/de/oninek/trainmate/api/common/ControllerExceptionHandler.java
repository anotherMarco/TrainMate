package de.oninek.trainmate.api.common;

import de.oninek.trainmate.api.controller.ControllerPackage;
import de.oninek.trainmate.api.exceptions.BodyMeasurementNotFoundException;
import de.oninek.trainmate.api.exceptions.UserAlreadyExistsException;
import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ControllerAdvice(basePackageClasses = ControllerPackage.class)
public class ControllerExceptionHandler {

    @ExceptionHandler
    @ApiResponse(responseCode = "404", description = "user not found",
            content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProblemDetail.class))})
    public ResponseEntity<ProblemDetail> userNotFound(UserNotFoundException unfe) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(NOT_FOUND);
        problemDetail.setTitle("User not found");
        problemDetail.setDetail(unfe.getMessage());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler
    @ApiResponse(responseCode = "409", content = @Content(mediaType = APPLICATION_JSON_VALUE))
    public ResponseEntity<ProblemDetail> userAlreadyExists(UserAlreadyExistsException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(CONFLICT);
        problemDetail.setTitle("Conflict");
        problemDetail.setDetail(e.getMessage());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler
    @ApiResponse(responseCode = "404", description = "measurement not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProblemDetail.class))})
    public ResponseEntity<ProblemDetail> measurementNotFound(BodyMeasurementNotFoundException bmnfe) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(NOT_FOUND);
        problemDetail.setTitle("Measurement not found");
        problemDetail.setDetail(bmnfe.getMessage());

        return ResponseEntity.of(problemDetail).build();
    }

}
