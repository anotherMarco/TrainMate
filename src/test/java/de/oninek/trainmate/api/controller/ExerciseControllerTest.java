package de.oninek.trainmate.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.service.ExerciseService;
import de.oninek.trainmate.api.testutil.ExerciseBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExerciseController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExerciseControllerTest {

    @MockBean
    private ExerciseService exerciseService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private ExerciseBuilder exerciseBuilder;

    @BeforeEach
    void setUp() {
        exerciseBuilder = new ExerciseBuilder();
    }

    @Nested
    class Post {

        @Test
        void test() throws Exception {
            CreateExerciseRequest createExerciseRequest = exerciseBuilder.buildCreateRequest();
            String json = objectMapper.writeValueAsString(createExerciseRequest);
            ExerciseResponse exerciseResponse = exerciseBuilder.buildResponse();
            when(exerciseService.create(createExerciseRequest)).thenReturn(exerciseResponse);


            mockMvc.perform(post("/exercises")
                            .contentType(APPLICATION_JSON)
                            .content(json))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id").value(exerciseResponse.id()))
                    .andExpect(jsonPath("$.name").value(exerciseResponse.name()))
                    .andExpect(jsonPath("$.name").value(exerciseResponse.name()))
                    .andExpect(jsonPath("$.claimedMuscles").isMap())
                    .andExpect(jsonPath("$.equipments").isArray());
        }
    }

}
