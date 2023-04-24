package de.oninek.trainmate.api.service;


import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;

public interface UserService {

    UserResponse findById(long id);

    UserResponse save(CreateUserRequest request);
}
