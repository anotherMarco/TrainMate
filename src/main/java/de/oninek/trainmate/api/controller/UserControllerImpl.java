package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponse> save(CreateUserRequest request) {
        UserResponse response = userService.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<UserResponse> findById(Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Override
    public ResponseEntity<Page<UserResponse>> findMany(Pageable pageable) {
        Page<UserResponse> page = userService.findMany(pageable);
        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
