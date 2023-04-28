package de.oninek.trainmate.api.service;


import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponse findById(long id);

    UserResponse save(CreateUserRequest request);

    Page<UserResponse> findMany(Pageable pageable);

    void delete(Long id);
}
