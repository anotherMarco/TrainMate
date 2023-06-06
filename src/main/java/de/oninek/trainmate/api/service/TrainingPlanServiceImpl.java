package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;
import de.oninek.trainmate.api.persistance.repository.TrainingPlanRepository;
import de.oninek.trainmate.api.service.mapper.TrainingPlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

    private final TrainingPlanRepository repository;
    private final TrainingPlanMapper mapper;
    @Override
    public Page<TrainingPlanResponse> findMany(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Override
    public TrainingPlanResponse create(TrainingPlanRequest request) {
        TrainingPlanEntity entity = mapper.toEntity(request);
        TrainingPlanEntity saved = repository.save(entity);
        return mapper.toResponse(saved);
    }
}
