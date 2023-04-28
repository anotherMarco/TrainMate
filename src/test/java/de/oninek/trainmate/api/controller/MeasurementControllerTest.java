package de.oninek.trainmate.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.service.BodyMeasurementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MeasurementController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MeasurementControllerTest {

    @MockBean
    private BodyMeasurementService measurementService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void when_user_not_found_return_404() throws Exception {
        CreateBodyMeasurementRequest measurement = new CreateBodyMeasurementRequest(72.0, 15.0, 33.0, LocalDateTime.of(2023, 12, 25, 0, 0));
        String jsonRequest = objectMapper.writeValueAsString(measurement);
        when(measurementService.save(anyLong(), any())).thenThrow(UserNotFoundException.class);

        mockMvc.perform(post("/users/1/measurements")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
