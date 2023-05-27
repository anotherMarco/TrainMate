package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import de.oninek.trainmate.api.persistance.entity.MuscleGroupEntity;
import de.oninek.trainmate.api.testutil.MuscleGroupBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MuscleGroupMapperTest {

    private MuscleGroupMapper sut;
    private MuscleGroupBuilder builder;

    @BeforeEach
    void setUp() {
        sut = new MuscleGroupMapperImpl();
        builder = new MuscleGroupBuilder();
    }

    @Test
    void map_to_entity() {
        MuscleGroupEntity entity = builder.buildEntity();

        MuscleGroupResponse actual = sut.entityToResponse(entity);

        assertThat(actual.id()).isEqualTo(entity.getId());
        assertThat(actual.name()).isEqualTo(entity.getName());
    }

}
