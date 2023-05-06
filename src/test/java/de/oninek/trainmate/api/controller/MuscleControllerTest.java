package de.oninek.trainmate.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oninek.trainmate.api.service.MuscleService;
import de.oninek.trainmate.api.testutil.MuscleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MuscleController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MuscleControllerTest {

    @MockBean
    private MuscleService muscleService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private MuscleBuilder muscleBuilder;

    @BeforeEach
    void setUp() {
        muscleBuilder = new MuscleBuilder();
    }

    @Test
    public void when_valid_request_return_200() throws Exception {
        mockMvc.perform(get("/muscles?page=0&size=20"))
                .andExpect(status().isOk());

        verify(muscleService, times(1)).findMany(null, Pageable.ofSize(20));
    }
}
