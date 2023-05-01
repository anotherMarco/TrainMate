package de.oninek.trainmate.api.controller;

import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Users")
@RequestMapping("users")
public interface UserController {

    @Operation(summary = "Create a user")
    @ApiResponse(responseCode = "201", description = "User was successfully created",
            headers = {@Header(name = HttpHeaders.LOCATION, description = "The uri where the created resource can be found")},
            content = @Content(mediaType = APPLICATION_JSON_VALUE)
    )
    @PostMapping
    ResponseEntity<UserResponse> save(@Valid @RequestBody CreateUserRequest request);

    @Operation(summary = "find a user by id")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON_VALUE))
    @GetMapping("{id}")
    ResponseEntity<UserResponse> findById(@PathVariable Long id);

    @Operation(summary = "Get a List of users", description = "Returns a paginated list of users, sorted by the specified attribut")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON_VALUE))
    @GetMapping
    ResponseEntity<Page<UserResponse>> findMany(Pageable pageable);

    @Operation(summary = "Delete an user by ID", operationId = "deleteUserById")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
