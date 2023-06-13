package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanEntryRequest;
import de.oninek.trainmate.api.dto.TrainingPlanEntryResponse;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.RepetitionRange;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntryEntity;
import de.oninek.trainmate.api.testutil.ExerciseBuilder;
import de.oninek.trainmate.api.testutil.TrainingPlanEntryTestDataBuilder;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TrainingPlanEntryMapper_Test {

    private TrainingPlanEntryMapper entryMapper;
    private TrainingPlanEntryTestDataBuilder testData;

    @BeforeEach
    void setUp() {
        entryMapper = new TrainingPlanEntryMapperImpl();
        testData = new TrainingPlanEntryTestDataBuilder();
    }

    @Nested
    class Entity_to_Response {

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
        void toResponseList() {
            TrainingPlanEntryEntity entity1 = testData.setExerciseBuilder(new ExerciseBuilder()).buildEntity();
            TrainingPlanEntryEntity entity2 = testData.setId(2L).setExerciseBuilder(new ExerciseBuilder()).buildEntity();
            List<TrainingPlanEntryEntity> entities = List.of(entity1, entity2);

            var result = entryMapper.toResponseList(entities);

            assertThat(result).hasSize(entities.size());
        }
    }

    @Nested
    class Request_to_Entity {

        @Test
        void responseToEntity() {
            TrainingPlanEntryRequest response = testData.buildRequest();

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
            TrainingPlanEntryRequest response = testData.setExerciseBuilder(new ExerciseBuilder()).buildRequest();

            TrainingPlanEntryEntity result = entryMapper.toEntity(response);

            assertThat(result.getExercise()).isNull();
        }


        @Test
        void toEntityList() {
            TrainingPlanEntryRequest request1 = testData.buildRequest();
            TrainingPlanEntryRequest request2 = testData.setId(2L).buildRequest();
            List<TrainingPlanEntryRequest> requests = List.of(request1, request2);

            List<TrainingPlanEntryEntity> result = entryMapper.toEntityList(requests);

            assertThat(result).hasSize(requests.size());
        }

    }



}
