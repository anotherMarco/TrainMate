package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import de.oninek.trainmate.api.persistance.repository.EquipmentRepository;
import de.oninek.trainmate.api.service.mapper.EquipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository repository;
    private final EquipmentMapper mapper;
    @Override
    public Page<EquipmentResponse> findMany(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::entityToResponse);
    }
}
