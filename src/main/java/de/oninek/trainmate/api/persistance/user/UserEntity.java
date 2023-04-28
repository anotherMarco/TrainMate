package de.oninek.trainmate.api.persistance.user;

import de.oninek.trainmate.api.persistance.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "uc_userentity_email", columnNames = {"email"})
})
public class UserEntity extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "display_name", unique = true)
    private String displayName;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<BodyMeasurementEntity> bodyMeasurements = new LinkedHashSet<>();

    public void addMeasurement(BodyMeasurementEntity measurement) {
        if (bodyMeasurements.add(measurement)) measurement.setUserEntity(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
