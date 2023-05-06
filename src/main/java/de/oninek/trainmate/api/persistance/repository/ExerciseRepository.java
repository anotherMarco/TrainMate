package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.exceptions.ExerciseNotFoundException;
import de.oninek.trainmate.api.persistance.entity.ClaimedMuscleEntity;
import de.oninek.trainmate.api.persistance.entity.ExerciseEntity;
import de.oninek.trainmate.api.persistance.entity.MuscleIntensity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ExerciseRepository extends TrainMateRepository<ExerciseEntity>, JpaSpecificationExecutor<ExerciseEntity> {

    default ExerciseEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new ExerciseNotFoundException(id));
    }

    Page<ExerciseEntity> findAll(Specification<ExerciseEntity> specification, Pageable pageable);

    static Specification<ExerciseEntity> isInMainMuscles(List<Long> ids) {
        return isInMuscles(ids, MuscleIntensity.MAIN);
    }

    static Specification<ExerciseEntity> isInSupportedMuscles(List<Long> ids) {
        return isInMuscles(ids, MuscleIntensity.SUPPORT);
    }

    static Specification<ExerciseEntity> isInMuscleGroup(List<Long> ids) {
        return (root, query, criteriaBuilder) -> {
            if (ids == null || ids.isEmpty()) return criteriaBuilder.conjunction();
            Join<ExerciseEntity, ClaimedMuscleEntity> claimedMuscles = root.join("claimedMuscles");
            Predicate isInIds = claimedMuscles.get("muscle").get("muscleGroup").get("id").in(ids);
            return criteriaBuilder.and(isInIds);
        };

    }

    private static Specification<ExerciseEntity> isInMuscles(List<Long> ids, MuscleIntensity intensity) {
        return (root, query, criteriaBuilder) -> {
            if (ids == null || ids.isEmpty()) return criteriaBuilder.conjunction();
            Join<ExerciseEntity, ClaimedMuscleEntity> claimedMuscles = root.join("claimedMuscles");
            Predicate isInIds = claimedMuscles.get("muscle").get("id").in(ids);
            Predicate isIntensity = criteriaBuilder.equal(claimedMuscles.get("intensity"), intensity);
            return criteriaBuilder.and(isInIds, isIntensity);
        };
    }
}
