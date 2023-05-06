package de.oninek.trainmate.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.service.BodyMeasurementService;
import de.oninek.trainmate.api.testutil.BodyMeasurementBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpHeaders.LOCATION;
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

    private BodyMeasurementBuilder measurementBuilder;

    @BeforeEach
    void setUp() {
        measurementBuilder = new BodyMeasurementBuilder();
    }

    @Test
    public void when_user_not_found_return_404() throws Exception {
        CreateBodyMeasurementRequest measurement = measurementBuilder.buildCreateRequest();
        String jsonRequest = objectMapper.writeValueAsString(measurement);
        when(measurementService.save(1L, measurement)).thenThrow(UserNotFoundException.class);

        mockMvc.perform(post("/users/1/measurements")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void successful_post_contains_location_header() throws Exception {
        CreateBodyMeasurementRequest measurement = measurementBuilder.buildCreateRequest();
        String jsonRequest = objectMapper.writeValueAsString(measurement);
        BodyMeasurementResponse measurementResponse = measurementBuilder.buildResponse();
        when(measurementService.save(1L, measurement)).thenReturn(measurementResponse);

        MockHttpServletResponse response = mockMvc.perform(post("/users/1/measurements")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn().getResponse();

        assertThat(response.getHeader(LOCATION)).contains("/users/1/measurements/" + measurementResponse.id());
    }



}
