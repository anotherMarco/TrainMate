package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.testutil.ClaimedMuscleBuilder;
import de.oninek.trainmate.api.testutil.EquipmentBuilder;
import de.oninek.trainmate.api.testutil.ExerciseBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static de.oninek.trainmate.api.persistance.entity.MuscleIntensity.MAIN;
import static de.oninek.trainmate.api.persistance.entity.MuscleIntensity.SUPPORT;
import static org.assertj.core.api.Assertions.assertThat;

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
        exerciseBuilder.addClaimedMuscle(new ClaimedMuscleBuilder().setMuscleIntensity(MAIN).setMuscleName("Chest"));
        exerciseBuilder.addClaimedMuscle(new ClaimedMuscleBuilder().setMuscleIntensity(SUPPORT).setMuscleName("Legs"));
        ExerciseEntity exerciseEntity = exerciseBuilder.buildEntity();

        ExerciseResponse actual = exerciseMapper.entityToResponse(exerciseEntity);

        assertThat(actual.name()).isEqualTo(exerciseEntity.getName());
        assertThat(actual.equipments()).hasSize(exerciseEntity.getEquipments().size());
        assertThat(actual.equipments()).contains("Weights");
        assertThat(actual.mainMuscles()).hasSize(1);
        assertThat(actual.mainMuscles()).hasSize(1);
        assertThat(actual.mainMuscles()).containsExactly("Chest");
        assertThat(actual.supportedMuscles()).containsExactly("Legs");
    }
}
