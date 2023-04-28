package de.oninek.trainmate.api;

import de.oninek.trainmate.api.dto.BodyMeasurementResponse;
import de.oninek.trainmate.api.dto.CreateUserRequest;
import de.oninek.trainmate.api.dto.UserResponse;
import de.oninek.trainmate.api.persistance.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserBuilder {

    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private LocalDateTime updatedAt = LocalDateTime.of(2023, 12, 25, 12, 0);
    private String firstName = "John";
    private String lastName = "Doe";
    private String displayName = "john.doe";
    private String email = "johnd@example.con";
    private List<BodyMeasurementBuilder> bodyMeasurementBuilders = new ArrayList<>();

    public UserEntity buildEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setCreatedAt(createdAt);
        userEntity.setUpdatedAt(updatedAt);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setDisplayName(displayName);
        userEntity.setEmail(email);
        for (BodyMeasurementBuilder bodyMeasurementBuilder : bodyMeasurementBuilders) {
            userEntity.getBodyMeasurements().add(bodyMeasurementBuilder.buildEntity());
        }
        return userEntity;
    }

    public CreateUserRequest buildCreateRequesst() {
        return new CreateUserRequest(firstName, lastName, email, displayName);
    }

    public UserResponse buildResponse() {
        BodyMeasurementResponse bodyMeasurementResponse = bodyMeasurementBuilders.stream()
                .map(BodyMeasurementBuilder::buildResponse)
                .min(Comparator.comparing(BodyMeasurementResponse::measuredAt))
                .orElse(null);
        return new UserResponse(id, firstName, lastName, email, displayName, bodyMeasurementResponse);
    }

    public UserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setBodyMeasurementBuilders(List<BodyMeasurementBuilder> bodyMeasurementBuilders) {
        this.bodyMeasurementBuilders = bodyMeasurementBuilders;
        return this;
    }
}
