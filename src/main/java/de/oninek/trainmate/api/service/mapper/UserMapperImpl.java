package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.persistance.entity.BodyMeasurementEntity;
import de.oninek.trainmate.api.persistance.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final BodyMeasurementMapper bodyMeasurementMapper;

    @Override
    public UserResponse entityToResponse(UserEntity entity) {
        BodyMeasurementResponse lastBodyMeasurement = entity.getBodyMeasurements().stream()
                .max(Comparator.comparing(BodyMeasurementEntity::getMeasuredAt))
                .map(bodyMeasurementMapper::entityToResponse)
                .orElse(null);

        return new UserResponse(entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getDisplayName(),
                lastBodyMeasurement);
    }

    @Override
    public UserEntity requestToEntity(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setDisplayName(request.displayName());
        userEntity.setEmail(request.email());
        userEntity.setFirstName(request.firstName());
        userEntity.setLastName(request.lastName());
        return userEntity;
    }
}
