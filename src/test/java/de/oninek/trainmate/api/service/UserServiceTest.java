package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.persistance.entity.UserEntity;
import de.oninek.trainmate.api.persistance.repository.UserRepository;
import de.oninek.trainmate.api.service.mapper.UserMapper;
import de.oninek.trainmate.api.testutil.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl sut;

    private UserBuilder userBuilder;

    @BeforeEach
    void setUp() {
        userBuilder = new UserBuilder();
    }

    @Test
    void findById() {
        UserEntity userEntity = userBuilder.buildEntity();
        when(userRepository.findByIdOrThrow(1L)).thenReturn(userEntity);

        sut.findById(1L);

        verify(userRepository, times(1)).findByIdOrThrow(1L);
    }

    @Test
    void delete_throws_exception_if_not_exists() {
        when(userRepository.existsById(1L)).thenReturn(false);

        assertThatThrownBy(() -> sut.delete(1L));
    }

    @Test
    void delete_if_exists() {
        when(userRepository.existsById(1L)).thenReturn(true);

        sut.delete(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}
