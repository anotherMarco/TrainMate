package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.dto.TrainingPlanEntryResponse;
import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;
import de.oninek.trainmate.api.persistance.repository.TrainingPlanRepository;
import de.oninek.trainmate.api.service.mapper.TrainingPlanEntryMapper;
import de.oninek.trainmate.api.service.mapper.TrainingPlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

    private final TrainingPlanRepository repository;
    private final TrainingPlanMapper trainingPlanMapper;
    private final TrainingPlanEntryMapper entryMapper;
    @Override
    public Page<TrainingPlanResponse> findMany(Pageable pageable) {
        return repository.findAll(pageable).map(trainingPlanMapper::toResponse);
    }

    @Override
    public TrainingPlanResponse create(TrainingPlanRequest request) {
        TrainingPlanEntity entity = trainingPlanMapper.toEntity(request);
        TrainingPlanEntity saved = repository.save(entity);
        return trainingPlanMapper.toResponse(saved);
    }

    @Override
    public TrainingPlanEntryResponse addEntry(TrainingPlanEntryRequest request, Long trainingPlanId) {
        TrainingPlanEntity trainingPlan = repository.findByIdOrThrow(trainingPlanId);
        TrainingPlanEntryEntity entry = entryMapper.toEntity(request);
        trainingPlan.addEntry(entry);
        repository.save(trainingPlan);
        return entryMapper.toResponse(entry);
    }
}
