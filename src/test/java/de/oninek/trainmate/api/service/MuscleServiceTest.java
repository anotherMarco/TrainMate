package de.oninek.trainmate.api.service;

import static org.junit.jupiter.api.Assertions.*;

import de.oninek.trainmate.api.persistance.repository.MuscleRepository;
import de.oninek.trainmate.api.service.mapper.MuscleMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MuscleServiceTest {
    @Mock
    private MuscleRepository muscleRepository;

    @Mock
    private MuscleMapper muscleMapper;

    @InjectMocks
    private MuscleServiceImpl muscleService;

    @Test
    public void find_all_when_muscleGroup_ids_is_empty() {
        Pageable pageable = Pageable.ofSize(20);
        when(muscleRepository.findAll(pageable)).thenReturn(Page.empty());

        muscleService.findMany(Collections.emptyList(), pageable);

        verify(muscleRepository, times(1)).findAll(pageable);
    }

    @Test
    public void find_all_when_muscleGroup_ids_is_null() {
        Pageable pageable = Pageable.ofSize(20);
        when(muscleRepository.findAll(pageable)).thenReturn(Page.empty());

        muscleService.findMany(null, pageable);

        verify(muscleRepository, times(1)).findAll(pageable);
    }

    @Test
    public void find_filtered_with_muscleGroup_ids() {
        Pageable pageable = Pageable.ofSize(20);
        List<Long> ids = List.of(1L);
        when(muscleRepository.findAllByMuscleGroupIdIn(pageable, ids)).thenReturn(Page.empty());

        muscleService.findMany(ids, pageable);

        verify(muscleRepository, times(1)).findAllByMuscleGroupIdIn(pageable, ids);
    }


}
