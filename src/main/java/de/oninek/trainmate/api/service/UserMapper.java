package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.persistance.entity.UserEntity;

public interface UserMapper {
    UserResponse entityToResponse(UserEntity entity);

    UserEntity requestToEntity(CreateUserRequest request);
}
