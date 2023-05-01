package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;
import de.oninek.trainmate.api.testutil.EquipmentBuilder;
import de.oninek.trainmate.api.testutil.ExerciseBuilder;
import de.oninek.trainmate.api.testutil.MuscleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static de.oninek.trainmate.api.persistance.entity.MuscleIntensity.MAIN;
import static de.oninek.trainmate.api.persistance.entity.MuscleIntensity.SUPPORT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExerciseMapperTest {

    private ExerciseMapper exerciseMapper;
    private ExerciseBuilder exerciseBuilder;

    @BeforeEach
    void setUp() {
        exerciseMapper = new ExerciseMapperImpl();
        exerciseBuilder = new ExerciseBuilder();
    }

    @Test
    void request_to_entity() {
        CreateExerciseRequest request = exerciseBuilder.buildCreateRequest();

        ExerciseEntity actual = exerciseMapper.requestToEntity(request);

        assertThat(actual.getName()).isEqualTo(request.name());
    }

    @Test
    void entity_to_response() {
        exerciseBuilder.addEquipment(new EquipmentBuilder().setName("Weights"));
        exerciseBuilder.addClaimedMuscle(MAIN, new MuscleBuilder().setName("Chest"));
        exerciseBuilder.addClaimedMuscle(SUPPORT, new MuscleBuilder().setName("Legs"));
        ExerciseEntity exerciseEntity = exerciseBuilder.buildEntity();

        ExerciseResponse actual = exerciseMapper.entityToResponse(exerciseEntity);

        assertThat(actual.name()).isEqualTo(exerciseEntity.getName());
        assertThat(actual.equipments()).hasSize(exerciseEntity.getEquipments().size());
        assertThat(actual.equipments()).contains("Weights");
        assertThat(actual.claimedMuscles()).hasSize(exerciseEntity.getClaimedMuscles().size());
        assertThat(actual.claimedMuscles()).contains(entry(MAIN, "Chest"), entry(SUPPORT, "Legs"));
    }
}
