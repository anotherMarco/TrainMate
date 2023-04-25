package de.oninek.trainmate.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CreateUserRequest(
        @Schema(example = "John") String firstName,
        @Schema(example = "Doe") String lastName,
        @Schema(example = "john.doe@example.com") @Email String email,
        @Schema(example = "j0hnDoE") @NotBlank String displayName
) implements Serializable {
}
