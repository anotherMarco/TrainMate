package de.oninek.trainmate.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oninek.trainmate.api.dto.CreateBodyMeasurementRequest;
import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.exceptions.UserAlreadyExistsException;
import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@AutoConfigureJsonTesters
class UserControllerTest {

    private JacksonTester<CreateUserRequest> requestJacksonTester;

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void when_not_found_return_404() throws Exception {
        when(userService.findById(1L)).thenThrow(UserNotFoundException.class);

        mockMvc.perform(get("/users/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void when_user_already_exists_return_409() throws Exception {
        CreateUserRequest request = new CreateUserRequest("John", "Doe", "jd@example.com", "johnDoe");
        when(userService.save(request)).thenThrow(UserAlreadyExistsException.class);
        String json = requestJacksonTester.write(request).getJson();

        mockMvc.perform(post("/users")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isConflict());
    }
}
