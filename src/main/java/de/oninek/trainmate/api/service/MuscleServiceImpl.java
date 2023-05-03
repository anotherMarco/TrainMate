package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.MuscleResponse;
import de.oninek.trainmate.api.persistance.repository.MuscleRepository;
import de.oninek.trainmate.api.service.mapper.MuscleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MuscleServiceImpl implements MuscleService {

    private final MuscleRepository muscleRepository;
    private final MuscleMapper muscleMapper;

    @Override
    public Page<MuscleResponse> findMany(Long muscleGroupId, Pageable pageable) {
        return muscleRepository.findAllByMuscleGroupIdOrFindAll(pageable, muscleGroupId).
                map(muscleMapper::entityToResponse);
    }
}
