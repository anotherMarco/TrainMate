package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.MuscleGroupResponse;
import de.oninek.trainmate.api.persistance.entity.MuscleGroupEntity;
import de.oninek.trainmate.api.persistance.repository.MuscleGroupRepository;
import de.oninek.trainmate.api.service.mapper.MuscleGroupMapper;
import de.oninek.trainmate.api.testutil.MuscleGroupBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MuscleGroupServiceImplTest {

    @InjectMocks
    private MuscleGroupServiceImpl sut;

    @Mock
    private MuscleGroupRepository muscleGroupRepository;

    @Spy
    private MuscleGroupMapper muscleGroupMapper;

   private MuscleGroupBuilder builder;


    @BeforeEach
    void setUp() {
        builder = new MuscleGroupBuilder();
    }

    @Test
    void findMany() {
        MuscleGroupEntity muscleGroupEntity = builder.buildEntity();
        Pageable pageable = Pageable.ofSize(10);
        when(muscleGroupRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(muscleGroupEntity)));

        Page<MuscleGroupResponse> actual = sut.findMany(pageable);

        verify(muscleGroupMapper, times(1)).entityToResponse(muscleGroupEntity);
    }


}
