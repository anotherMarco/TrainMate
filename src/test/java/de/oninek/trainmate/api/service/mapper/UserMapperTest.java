package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.persistance.entity.BodyMeasurementEntity;
import de.oninek.trainmate.api.persistance.entity.UserEntity;
import de.oninek.trainmate.api.service.mapper.BodyMeasurementMapperImpl;
import de.oninek.trainmate.api.service.mapper.UserMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserMapperTest {

    private UserMapperImpl mapper;

    @BeforeEach
    void setUp() {
        BodyMeasurementMapperImpl bodyMeasurementMapper = new BodyMeasurementMapperImpl();
        mapper = new UserMapperImpl(bodyMeasurementMapper);
    }


    @Test
    void entity_to_response() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setEmail("john.doe@example.com");
        entity.setDisplayName("johndoe");
        Set<BodyMeasurementEntity> bodyMeasurements = new LinkedHashSet<>();
        BodyMeasurementEntity bodyMeasurementEntity = new BodyMeasurementEntity();
        bodyMeasurementEntity.setId(1L);
        bodyMeasurementEntity.setWeight(70.0);
        bodyMeasurementEntity.setFatMassWeight(25.0);
        bodyMeasurementEntity.setSkeletalMuscleWeight(50.0);
        bodyMeasurementEntity.setFatMassWeight(17.5);
        bodyMeasurements.add(bodyMeasurementEntity);
        entity.setBodyMeasurements(bodyMeasurements);

        UserResponse response = mapper.entityToResponse(entity);

        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(entity.getId());
        assertThat(response.firstName()).isEqualTo(entity.getFirstName());
        assertThat(response.lastName()).isEqualTo(entity.getLastName());
        assertThat(response.email()).isEqualTo(entity.getEmail());
        assertThat(response.displayName()).isEqualTo(entity.getDisplayName());
        assertThat(response.bodyMeasurement()).isNotNull();
        assertThat(response.bodyMeasurement().id()).isEqualTo(bodyMeasurementEntity.getId());
        assertThat(response.bodyMeasurement().weight()).isEqualTo(bodyMeasurementEntity.getWeight());
        assertThat(response.bodyMeasurement().fatWeight()).isEqualTo(bodyMeasurementEntity.getFatMassWeight());
        assertThat(response.bodyMeasurement().skeletalMuscleWeight()).isEqualTo(bodyMeasurementEntity.getSkeletalMuscleWeight());
        assertThat(response.bodyMeasurement().measuredAt()).isEqualTo(bodyMeasurementEntity.getMeasuredAt());
    }

    @Test
    void entity_to_response_with_null_body_measurements() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setEmail("john.doe@example.com");
        entity.setDisplayName("johndoe");

        UserResponse response = mapper.entityToResponse(entity);

        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(entity.getId());
        assertThat(response.firstName()).isEqualTo(entity.getFirstName());
        assertThat(response.lastName()).isEqualTo(entity.getLastName());
        assertThat(response.email()).isEqualTo(entity.getEmail());
        assertThat(response.displayName()).isEqualTo(entity.getDisplayName());
        assertThat(response.bodyMeasurement()).isNull();
    }

    @Test
    void mapper_uses_latest_measurement() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setEmail("john.doe@example.com");
        entity.setDisplayName("johndoe");
        Set<BodyMeasurementEntity> bodyMeasurements = new LinkedHashSet<>();
        BodyMeasurementEntity bodyMeasurementEntity = new BodyMeasurementEntity();
        bodyMeasurementEntity.setId(1L);
        bodyMeasurementEntity.setWeight(70.0);
        bodyMeasurementEntity.setFatMassWeight(25.0);
        bodyMeasurementEntity.setSkeletalMuscleWeight(50.0);
        bodyMeasurementEntity.setFatMassWeight(17.5);
        bodyMeasurementEntity.setMeasuredAt(LocalDateTime.of(2023, 12, 25, 0, 0));
        bodyMeasurements.add(bodyMeasurementEntity);
        BodyMeasurementEntity bodyMeasurementEntity2 = new BodyMeasurementEntity();
        bodyMeasurementEntity2.setId(1L);
        bodyMeasurementEntity2.setWeight(70.0);
        bodyMeasurementEntity2.setFatMassWeight(25.0);
        bodyMeasurementEntity2.setSkeletalMuscleWeight(50.0);
        bodyMeasurementEntity2.setFatMassWeight(17.5);
        bodyMeasurementEntity2.setMeasuredAt(LocalDateTime.of(2021, 12, 25, 0, 0));
        bodyMeasurements.add(bodyMeasurementEntity2);
        entity.setBodyMeasurements(bodyMeasurements);

        UserResponse response = mapper.entityToResponse(entity);

        assertThat(response.bodyMeasurement().measuredAt()).isEqualTo(LocalDateTime.of(2023, 12, 25, 0, 0));
    }

    @Test
    void create_request_to_entity() {
        CreateUserRequest request = new CreateUserRequest("John", "Doe", "john.doe@example.com", "johndoe");

        UserEntity result = mapper.requestToEntity(request);

        assertThat(result.getFirstName()).isEqualTo(request.firstName());
        assertThat(result.getLastName()).isEqualTo(request.lastName());
        assertThat(result.getEmail()).isEqualTo(request.email());
        assertThat(result.getDisplayName()).isEqualTo(request.displayName());
        assertThat(result.getBodyMeasurements()).isEmpty();
        assertThat(result.getCreatedAt()).isNull();
    }

}
