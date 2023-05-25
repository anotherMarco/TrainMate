package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.MuscleResponse;
import de.oninek.trainmate.api.persistance.repository.MuscleRepository;
import de.oninek.trainmate.api.service.mapper.MuscleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class MuscleServiceImpl implements MuscleService {

    private final MuscleRepository muscleRepository;
    private final MuscleMapper muscleMapper;

    @Override
    public Page<MuscleResponse> findMany(List<Long> muscleGroupIds, Pageable pageable) {
        if (muscleGroupIds == null || muscleGroupIds.isEmpty()) {
            return muscleRepository.findAll(pageable)
                    .map(muscleMapper::entityToResponse);
        }
        return muscleRepository.findAllByMuscleGroupIdIn(pageable, muscleGroupIds)
                .map(muscleMapper::entityToResponse);

    }
}
