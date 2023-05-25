package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.persistance.entity.UserEntity;
import de.oninek.trainmate.api.persistance.repository.UserRepository;
import de.oninek.trainmate.api.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class UserServiceImpl implements UserService {

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

    @Override
    public Page<UserResponse> findMany(Pageable pageable) {
        return userRepository.findAll(pageable).map(mapper::entityToResponse);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) throw new UserNotFoundException(id);
        userRepository.deleteById(id);
    }
}
