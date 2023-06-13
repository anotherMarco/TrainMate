package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;
import de.oninek.trainmate.api.testutil.TrainingPlanTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class TrainingPlanMapperImpl_Test {

    private TrainingPlanMapper trainingPlanMapper;
    private TrainingPlanTestDataBuilder testDataBuilder;

    @Spy
    private TrainingPlanEntryMapper entryMapper;

    @BeforeEach
    void setUp() {
        testDataBuilder = new TrainingPlanTestDataBuilder();
        entryMapper = Mockito.mock(TrainingPlanEntryMapper.class);
        trainingPlanMapper = new TrainingPlanMapperImpl(entryMapper);
    }

    @Test
    void test() {
        TrainingPlanEntity entity = testDataBuilder.buildEntity();

        TrainingPlanResponse result = trainingPlanMapper.toResponse(entity);

        verify(entryMapper, times(1)).toResponseList(any());
        assertThat(result.id()).isEqualTo(entity.getId());
        assertThat(result.name()).isEqualTo(entity.getName());
    }
}
