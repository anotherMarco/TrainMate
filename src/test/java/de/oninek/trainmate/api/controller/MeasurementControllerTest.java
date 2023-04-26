package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.service.BodyMeasurementService;
import de.oninek.trainmate.api.service.UserService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MeasurementController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@AutoConfigureJsonTesters
class MeasurementControllerTest {

    @MockBean
    private BodyMeasurementService measurementService;
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void when_user_not_found_return_404() throws Exception {
        when(measurementService.save(anyLong(), any())).thenThrow(UserNotFoundException.class);

        mockMvc.perform(post("/users/1/measurements"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
