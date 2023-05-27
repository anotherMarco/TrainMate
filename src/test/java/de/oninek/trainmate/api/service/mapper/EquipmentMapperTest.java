package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;
import de.oninek.trainmate.api.testutil.EquipmentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EquipmentMapperTest {

    private EquipmentMapper sut;
    private EquipmentBuilder builder;

    @BeforeEach
    void setUp() {
        sut = new EquipmentMapperImpl();
        builder = new EquipmentBuilder();
    }

    @Test
    void map_to_response() {
        EquipmentEntity entity = builder.buildEntity();

        EquipmentResponse actual = sut.entityToResponse(entity);

        assertThat(actual.id()).isEqualTo(entity.getId());
        assertThat(actual.name()).isEqualTo(entity.getName());
    }
}
