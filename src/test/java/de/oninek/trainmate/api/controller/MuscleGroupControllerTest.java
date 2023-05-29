package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.service.MuscleGroupService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(MuscleGroupController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MuscleGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MuscleGroupService service;

    @Test
    void findMany_returns_200() throws Exception {

        when(service.findMany(Mockito.any(Pageable.class))).thenReturn(Page.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/muscle-groups"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
