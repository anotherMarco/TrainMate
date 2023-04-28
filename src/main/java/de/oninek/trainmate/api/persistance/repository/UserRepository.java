package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.persistance.entity.UserEntity;


public interface UserRepository extends TrainMateRepository<UserEntity> {

    default UserEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + "can't be found"));
    }
}
