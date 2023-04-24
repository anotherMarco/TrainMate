package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.persistance.user.BodyMeasurementEntity;
import de.oninek.trainmate.api.persistance.user.BodyMeasurementRepository;
import de.oninek.trainmate.api.persistance.user.UserEntity;
import de.oninek.trainmate.api.persistance.user.UserRepository;
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
