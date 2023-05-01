package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.persistance.entity.BodyMeasurementEntity;
import de.oninek.trainmate.api.testutil.BodyMeasurementBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BodyMeasurementMapperTest {

    private BodyMeasurementMapper mapper;
    private BodyMeasurementBuilder bodyMeasurementBuilder;

    @BeforeEach
    void setUp() {
        mapper = new BodyMeasurementMapperImpl();
        bodyMeasurementBuilder = new BodyMeasurementBuilder();
    }

    @Test
    void entity_to_response() {
        BodyMeasurementEntity entity = new BodyMeasurementEntity();
        entity.setId(1L);
        entity.setWeight(70.0);
        entity.setFatMassWeight(25.0);
        entity.setSkeletalMuscleWeight(50.0);
        entity.setFatMassWeight(17.5);
        entity.setMeasuredAt(LocalDateTime.now());

        BodyMeasurementResponse dto = mapper.entityToResponse(entity);

        assertThat(dto).isNotNull();
        assertThat(dto.id()).isEqualTo(entity.getId());
        assertThat(dto.weight()).isEqualTo(entity.getWeight());
        assertThat(dto.fatWeight()).isEqualTo(entity.getFatMassWeight());
        assertThat(dto.skeletalMuscleWeight()).isEqualTo(entity.getSkeletalMuscleWeight());
        assertThat(dto.measuredAt()).isEqualTo(entity.getMeasuredAt());
    }

    @Test
    void entity_to_response_with_null_values() {
        BodyMeasurementEntity entity = new BodyMeasurementEntity();
        entity.setId(1L);
        entity.setWeight(70.0);
        entity.setMeasuredAt(LocalDateTime.of(2023, 12, 25, 0, 0));

        BodyMeasurementResponse dto = mapper.entityToResponse(entity);

        assertThat(dto).isNotNull();
        assertThat(dto.id()).isEqualTo(entity.getId());
        assertThat(dto.weight()).isEqualTo(entity.getWeight());
        assertThat(dto.fatWeight()).isNull();
        assertThat(dto.skeletalMuscleWeight()).isNull();
        assertThat(dto.measuredAt()).isEqualTo(entity.getMeasuredAt());
    }

    @Test
    void request_to_entity() {
        BodyMeasurementEntity excepted = bodyMeasurementBuilder.buildEntity();
        CreateBodyMeasurementRequest request = bodyMeasurementBuilder.buildCreateRequest();

        BodyMeasurementEntity actual = mapper.requestToEntity(request);

        assertThat(actual.getMeasuredAt()).isEqualTo(excepted.getMeasuredAt());
        assertThat(actual.getFatMassWeight()).isEqualTo(excepted.getFatMassWeight());
        assertThat(actual.getWeight()).isEqualTo(excepted.getWeight());
        assertThat(actual.getSkeletalMuscleWeight()).isEqualTo(excepted.getSkeletalMuscleWeight());
    }


}
