package de.oninek.trainmate.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CreateUserRequest(@Schema(example = "John") @NotBlank String firstName,
                                @Schema(example = "Doe") @NotBlank String lastName,
                                @Schema(example = "john.doe@example.com") @NotBlank @Email String email,
                                @Schema(example = "j0hnDoE") @NotBlank String displayName) implements Serializable {
}
