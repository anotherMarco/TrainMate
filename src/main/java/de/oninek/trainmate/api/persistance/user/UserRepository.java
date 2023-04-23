package de.oninek.trainmate.api.persistance.user;

import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.persistance.TrainMateRepository;


public interface UserRepository extends TrainMateRepository<UserEntity> {

    default UserEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + "can't be found"));
    }
}
