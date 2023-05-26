package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EquipmentService {

    Page<EquipmentResponse> findMany(Pageable pageable);
}
