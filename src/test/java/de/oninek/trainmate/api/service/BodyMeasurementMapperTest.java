package de.oninek.trainmate.api.service;
import static org.assertj.core.api.Assertions.*;


import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.persistance.user.BodyMeasurementEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BodyMeasurementMapperTest {

    private BodyMeasurementMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new BodyMeasurementMapperImpl();
    }

    @Test
    void entity_to_response() {
        BodyMeasurementEntity entity = new BodyMeasurementEntity();
        entity.setId(1L);
        entity.setWeight(70.0);
        entity.setFatPercentage(25.0);
        entity.setSkeletalMuscleWeight(50.0);
        entity.setFatMassWeight(17.5);
        entity.setMeasuredAt(LocalDateTime.now());

        BodyMeasurementResponse dto = mapper.entityToResponse(entity);

        assertThat(dto).isNotNull();
        assertThat(dto.id()).isEqualTo(entity.getId());
        assertThat(dto.weight()).isEqualTo(entity.getWeight());
        assertThat(dto.fatPercentage()).isEqualTo(entity.getFatPercentage());
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
        assertThat(dto.fatPercentage()).isNull();
        assertThat(dto.skeletalMuscleWeight()).isNull();
        assertThat(dto.measuredAt()).isEqualTo(entity.getMeasuredAt());
    }


}
