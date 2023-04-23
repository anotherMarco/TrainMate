package de.oninek.trainmate.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CreateUserRequest(
        String firstName,
        String lastName,
        @Email String email,
        @NotBlank String displayName
) implements Serializable {
}
