package de.oninek.trainmate.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oninek.trainmate.api.dto.AddClaimedMusclesRequest;
import de.oninek.trainmate.api.dto.AddEquipmentsRequest;
import de.oninek.trainmate.api.dto.CreateExerciseRequest;
import de.oninek.trainmate.api.dto.ExerciseResponse;
import de.oninek.trainmate.api.exceptions.MuscleNotFoundException;
import de.oninek.trainmate.api.service.ExerciseService;
import de.oninek.trainmate.api.testutil.ClaimedMuscleBuilder;
import de.oninek.trainmate.api.testutil.EquipmentBuilder;
import de.oninek.trainmate.api.testutil.ExerciseBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
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
    private ClaimedMuscleBuilder claimedMuscleBuilder;
    private EquipmentBuilder equipmentBuilder;


    @BeforeEach
    void setUp() {
        exerciseBuilder = new ExerciseBuilder();
        claimedMuscleBuilder = new ClaimedMuscleBuilder();
        equipmentBuilder = new EquipmentBuilder();
    }

    @Nested
    class Post {

        @Test
        void successful_post_returns_201() throws Exception {
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
                    .andExpect(jsonPath("$.mainMuscles").isArray())
                    .andExpect(jsonPath("$.supportedMuscles").isArray());
        }
    }

    @Test
    public void successful_add_muscle_returns_201() throws Exception {
        AddClaimedMusclesRequest request = claimedMuscleBuilder.buildAddRequest();
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/exercises/1/claimed-muscles")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated());
    }

    @Test
    public void add_muscle_returns_404_when_exercise_not_found() throws Exception {
        AddClaimedMusclesRequest request = claimedMuscleBuilder.buildAddRequest();
        String jsonRequest = objectMapper.writeValueAsString(request);
        when(exerciseService.addClaimedMuscle(any(), any())).thenThrow(MuscleNotFoundException.class);

        mockMvc.perform(post("/exercises/1/claimed-muscles")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound());
    }

    @Test
    public void add_equipment_returns_201() throws Exception {
        AddEquipmentsRequest request = equipmentBuilder.buildRequest();
        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/exercises/1/equipments")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated());
    }

}
