package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EquipmentControllerImpl implements EquipmentController {
    @Override
    public ResponseEntity<Page<EquipmentResponse>> findMany(Pageable pageable) {
        return null;
    }
}
