package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.MuscleResponse;
import de.oninek.trainmate.api.persistance.entity.MuscleEntity;
import de.oninek.trainmate.api.testutil.MuscleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MuscleMapperTest {

    private MuscleMapper sut;
    private MuscleBuilder builder;

    @BeforeEach
    void setUp() {
        sut = new MuscleMapperImpl();
        builder = new MuscleBuilder();
    }

    @Test
    void map_to_entity() {
        MuscleEntity entity = builder.buildEntity();

        MuscleResponse actual = sut.entityToResponse(entity);

        assertThat(actual.id()).isEqualTo(entity.getId());
        assertThat(actual.muscleGroupId()).isEqualTo(entity.getMuscleGroup().getId());
        assertThat(actual.name()).isEqualTo(entity.getName());
        assertThat(actual.muscleGroupId()).isEqualTo(entity.getMuscleGroup().getId());
        assertThat(actual.muscleGroupName()).isEqualTo(entity.getMuscleGroup().getName());
    }
}
