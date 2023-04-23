package de.oninek.trainmate.api.service;


import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    UserResponse findById(Long id);

    UserResponse save(CreateUserRequest request);
}
