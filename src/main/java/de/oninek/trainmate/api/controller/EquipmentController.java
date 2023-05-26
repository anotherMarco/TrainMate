package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Equipments")
@RequestMapping("equipments")
public interface EquipmentController {

    @Operation(summary = "Find all equipments", operationId = "findManyEquipments")
    @PageableAsQueryParam
    @GetMapping
    ResponseEntity<Page<EquipmentResponse>> findMany(@Parameter(hidden = true) Pageable pageable);
}
