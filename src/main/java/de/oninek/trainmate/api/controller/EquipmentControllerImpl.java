package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import de.oninek.trainmate.api.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class EquipmentControllerImpl implements EquipmentController {

    private final EquipmentService service;
    @Override
    public ResponseEntity<Page<EquipmentResponse>> findMany(Pageable pageable) {
        Page<EquipmentResponse> equipments = service.findMany(pageable);
        return ResponseEntity.ok(equipments);
    }
}
