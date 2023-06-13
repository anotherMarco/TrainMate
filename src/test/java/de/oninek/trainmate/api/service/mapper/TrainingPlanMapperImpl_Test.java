package de.oninek.trainmate.api.service.mapper;

import de.oninek.trainmate.api.dto.TrainingPlanRequest;
import de.oninek.trainmate.api.dto.TrainingPlanResponse;
import de.oninek.trainmate.api.persistance.entity.TrainingPlanEntity;
import de.oninek.trainmate.api.testutil.TrainingPlanEntryTestDataBuilder;
import de.oninek.trainmate.api.testutil.TrainingPlanTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TrainingPlanMapperImpl_Test {

    private TrainingPlanMapper sut;
    private TrainingPlanTestDataBuilder testDataBuilder;

    @Spy
    private TrainingPlanEntryMapper entryMapper;

    @BeforeEach
    void setUp() {
        testDataBuilder = new TrainingPlanTestDataBuilder();
        entryMapper = Mockito.mock(TrainingPlanEntryMapper.class);
        sut = new TrainingPlanMapperImpl(entryMapper);
    }

    @Test
    void entityToResponse() {
        TrainingPlanEntity entity = testDataBuilder.buildEntity();

        TrainingPlanResponse result = sut.toResponse(entity);

        verify(entryMapper, times(1)).toResponseList(any());
        assertThat(result.id()).isEqualTo(entity.getId());
        assertThat(result.name()).isEqualTo(entity.getName());
    }

    @Test
    void requestToEntity() {
        TrainingPlanRequest request = testDataBuilder.buildRequest();

        TrainingPlanEntity result = sut.toEntity(request);

        assertThat(result.getName()).isEqualTo(request.name());
        assertThat(result.getEntries()).isEmpty();
    }

    @Test
    void map_entries() {
        TrainingPlanRequest request = testDataBuilder.addEntry(new TrainingPlanEntryTestDataBuilder())
                .addEntry(new TrainingPlanEntryTestDataBuilder().setId(2L))
                .buildRequest();

        TrainingPlanEntity result = sut.toEntity(request);

        verify(entryMapper, times(1)).toEntityList(request.entries());
    }
}
