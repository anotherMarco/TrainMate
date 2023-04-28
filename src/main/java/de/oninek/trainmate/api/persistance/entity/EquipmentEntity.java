package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "equipments")
public class EquipmentEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentEntity that = (EquipmentEntity) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + getId() + ", " +
               "createdAt = " + getCreatedAt() + ", " +
               "updatedAt = " + getUpdatedAt() + ", " +
               "name = " + getName() + ")";
    }
}
