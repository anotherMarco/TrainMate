package de.oninek.trainmate.api.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record AddEquipmentsRequest(@NotEmpty List<Long> ids) {
}
