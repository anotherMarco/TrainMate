package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
public interface UserController {

    @PostMapping
    ResponseEntity<UserResponse> save(@Valid @RequestBody CreateUserRequest request);

    @GetMapping("{id}")
    ResponseEntity<UserResponse> findById(@PathVariable long id);
}
