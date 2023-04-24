package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.persistance.user.UserEntity;
import de.oninek.trainmate.api.persistance.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    public UserResponse findById(long id) {
        UserEntity entity = userRepository.findByIdOrThrow(id);
        return mapper.entityToResponse(entity);
    }

    @Override
    public UserResponse save(CreateUserRequest request) {
        UserEntity userEntity = mapper.requestToEntity(request);
        UserEntity saved = userRepository.save(userEntity);

        return mapper.entityToResponse(saved);
    }
}
