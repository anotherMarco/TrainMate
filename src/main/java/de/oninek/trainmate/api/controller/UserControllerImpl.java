package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponse> save(CreateUserRequest request) {
        return ResponseEntity.ok(userService.save(request));
    }
}
