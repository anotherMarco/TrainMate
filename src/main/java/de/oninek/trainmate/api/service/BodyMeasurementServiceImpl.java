package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.persistance.entity.BodyMeasurementEntity;
import de.oninek.trainmate.api.persistance.repository.BodyMeasurementRepository;
import de.oninek.trainmate.api.persistance.entity.UserEntity;
import de.oninek.trainmate.api.persistance.repository.UserRepository;
import de.oninek.trainmate.api.service.mapper.BodyMeasurementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BodyMeasurementServiceImpl implements BodyMeasurementService {

    private final BodyMeasurementMapper bodyMeasurementMapper;
    private final UserRepository userRepository;
    private final BodyMeasurementRepository bodyMeasurementRepository;

    @Override
    public BodyMeasurementResponse save(long userId, CreateBodyMeasurementRequest request) {
        UserEntity user = userRepository.findByIdOrThrow(userId);
        BodyMeasurementEntity bodyMeasurement = bodyMeasurementMapper.requestToEntity(request);
        bodyMeasurement.setUserEntity(user);
        BodyMeasurementEntity saved = bodyMeasurementRepository.save(bodyMeasurement);
        return bodyMeasurementMapper.entityToResponse(saved);
    }
}
