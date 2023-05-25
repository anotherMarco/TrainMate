package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import de.oninek.trainmate.api.persistance.repository.MuscleGroupRepository;
import de.oninek.trainmate.api.service.mapper.MuscleGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class MuscleGroupServiceImpl implements MuscleGroupService {

    private final MuscleGroupMapper mapper;
    private final MuscleGroupRepository repository;

    @Override
    public Page<MuscleGroupResponse> findMany(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::entityToResponse);
    }
}
