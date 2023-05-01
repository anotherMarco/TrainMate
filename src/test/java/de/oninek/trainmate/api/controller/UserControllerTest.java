package de.oninek.trainmate.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oninek.trainmate.api.testutil.UserBuilder;
import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.exceptions.UserAlreadyExistsException;
import de.oninek.trainmate.api.exceptions.UserNotFoundException;
import de.oninek.trainmate.api.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserControllerTest {


    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private UserBuilder userBuilder;



    @BeforeEach
    void setUp() {
        userBuilder = new UserBuilder();
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Nested
    class Post {
        @Test
        public void when_not_found_return_404() throws Exception {
            when(userService.findById(1L)).thenThrow(UserNotFoundException.class);

            mockMvc.perform(get("/users/1"))
                    .andDo(print())
                    .andExpect(status().isNotFound());
        }

        @Test
        public void when_user_already_exists_return_409() throws Exception {
            CreateUserRequest request = userBuilder.buildCreateRequesst();
            String json = objectMapper.writeValueAsString(request);
            when(userService.save(request)).thenThrow(UserAlreadyExistsException.class);

            mockMvc.perform(post("/users")
                            .contentType(APPLICATION_JSON)
                            .content(json))
                    .andExpect(status().isConflict());
        }

        @Test
        void when_success_then_provide_location_header() throws Exception {
            CreateUserRequest request = userBuilder.buildCreateRequesst();
            String json = objectMapper.writeValueAsString(request);
            when(userService.save(request)).thenReturn(userBuilder.buildResponse());

            MockHttpServletResponse actual = mockMvc.perform(post("/users")
                    .contentType(APPLICATION_JSON)
                    .content(json)).andReturn().getResponse();

            assertThat(actual.getHeader(HttpHeaders.LOCATION)).contains("/users/1");
            assertThat(actual.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        }
    }

    @Nested
    class Get {

        @Test
        void when_not_found_return_404() throws Exception {
            when(userService.findById(1L)).thenThrow(UserNotFoundException.class);

            mockMvc.perform(get("/users/1"))
                    .andExpect(status().isNotFound());
        }

        @Test
        void when_found_return_200() throws Exception {
            UserResponse response = userBuilder.buildResponse();
            when(userService.findById(1L)).thenReturn(response);

            mockMvc.perform(get("/users/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(objectMapper.writeValueAsString(response)));
        }
    }

    @Nested
    class Delete {

        @Test
        void when_not_found_return_404() throws Exception {
            doThrow(new UserNotFoundException(1L)).when(userService).delete(1L);

            mockMvc.perform(delete("/users/1"))
                    .andExpect(status().isNotFound());
        }
    }
}
