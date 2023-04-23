package de.oninek.trainmate.api.persistance.user;

import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=create-drop")
@Testcontainers
class UserRepositoryTest {

    @Container
    static PostgreSQLContainer testContainer = new PostgreSQLContainer<>("postgres:13");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", testContainer::getJdbcUrl);
        registry.add("spring.datasource.username", testContainer::getUsername);
        registry.add("spring.datasource.password", testContainer::getPassword);
    }

    @Autowired
    private DataSource dataSource;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        Iterable<UserEntity> all = repository.findAll();
        assertThat(all).isEmpty();
    }

    @Test
    void throw_exception_when_id_not_found() {
        assertThatThrownBy(() -> repository.findByIdOrThrow(2L)).isInstanceOf(UserNotFoundException.class);
    }

    @Test
    void save_user() {
        UserEntity userEntity = new UserEntity();
        userEntity.setLastName("John");
        userEntity.setDisplayName("john.doe");
        userEntity.setEmail("john.doe@example.com");
        repository.save(userEntity);

        Iterable<UserEntity> entities = repository.findAll();
        assertThat(entities).hasSize(1);
    }




}
