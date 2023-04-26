package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Users")
@RequestMapping("users")
public interface UserController {

    @ApiResponse(responseCode = "201", description = "User was successfully created",
            headers = {@Header(name = HttpHeaders.LOCATION, description = "The uri where the created resource can be found")},
            content = @Content(mediaType = APPLICATION_JSON_VALUE)
    )
    @PostMapping
    ResponseEntity<UserResponse> save(@Valid @RequestBody CreateUserRequest request);

    @ApiResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "User not found")
    @GetMapping("{id}")
    ResponseEntity<UserResponse> findById(@PathVariable long id);
}
