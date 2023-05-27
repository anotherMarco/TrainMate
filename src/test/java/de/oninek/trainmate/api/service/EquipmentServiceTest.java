package de.oninek.trainmate.api.service;

import de.oninek.trainmate.api.dto.EquipmentResponse;
import de.oninek.trainmate.api.persistance.entity.EquipmentEntity;
import de.oninek.trainmate.api.persistance.repository.EquipmentRepository;
import de.oninek.trainmate.api.service.mapper.EquipmentMapper;
import de.oninek.trainmate.api.testutil.EquipmentBuilder;
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
class EquipmentServiceTest {

    @InjectMocks
    private EquipmentServiceImpl sut;

    @Mock
    private EquipmentRepository equipmentRepository;

    @Spy
    private EquipmentMapper equipmentMapper;

    EquipmentBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new EquipmentBuilder();
    }

    @Test
    void findMany() {
        EquipmentEntity equipmentEntity = builder.buildEntity();
        Pageable pageable = Pageable.ofSize(10);
        when(equipmentRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(equipmentEntity)));

        Page<EquipmentResponse> actual = sut.findMany(pageable);

        verify(equipmentMapper, times(1)).entityToResponse(equipmentEntity);
    }

}
