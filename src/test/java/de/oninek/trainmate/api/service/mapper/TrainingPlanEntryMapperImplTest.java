package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.dto.TrainingPlanEntryResponse;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.RepetitionRange;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;
import de.oninek.trainmate.api.testutil.ExerciseBuilder;
import de.oninek.trainmate.api.testutil.TrainingPlanEntryTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TrainingPlanEntryMapperImplTest {

    private TrainingPlanEntryMapper entryMapper;
    private TrainingPlanEntryTestDataBuilder testData;

    @BeforeEach
    void setUp() {
        entryMapper = new TrainingPlanEntryMapperImpl();
        testData = new TrainingPlanEntryTestDataBuilder();
    }

    @Test
    void entityToResponse() {
        TrainingPlanEntryEntity entity = testData.setExerciseBuilder(new ExerciseBuilder()).buildEntity();

        TrainingPlanEntryResponse result = entryMapper.toResponse(entity);

        assertThat(result.id()).isEqualTo(entity.getId());
        assertThat(result.sets()).isEqualTo(entity.getSets());
        assertThat(result.weight()).isEqualTo(entity.getWeight());
        RepetitionRange repetitions = entity.getRepetitions();
        assertThat(result.maxRepetitions()).isEqualTo(repetitions.getMax());
        assertThat(result.minRepetitions()).isEqualTo(repetitions.getMin());
        ExerciseEntity exercise = entity.getExercise();
        assertThat(result.exerciseName()).isEqualTo(exercise.getName());
        assertThat(result.exerciseId()).isEqualTo(exercise.getId());
        assertThat(result.ordinalNumber()).isEqualTo(entity.getOrdinalNumber());
    }

    @Test
    void responseToEntity() {
        TrainingPlanEntryRequest response = testData.buildResponse();

        TrainingPlanEntryEntity result = entryMapper.toEntity(response);

        RepetitionRange repetitions = result.getRepetitions();
        assertThat(repetitions.getMin()).isEqualTo(response.minRepetitions());
        assertThat(repetitions.getMax()).isEqualTo(response.maxRepetitions());
        assertThat(result.getSets()).isEqualTo(response.sets());
        assertThat(result.getWeight()).isEqualTo(response.weight());
        assertThat(result.getSeconds()).isEqualTo(response.seconds());
    }

    @Test
    void exercise_should_be_null() {
        TrainingPlanEntryRequest response = testData.setExerciseBuilder(new ExerciseBuilder()).buildResponse();

        TrainingPlanEntryEntity entry = entryMapper.toEntity(response);

        assertThat(entry.getExercise()).isNull();
    }
}
