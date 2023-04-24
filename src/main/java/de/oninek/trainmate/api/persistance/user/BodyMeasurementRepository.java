package de.oninek.trainmate.api.persistance.user;

import de.oninek.trainmate.api.exceptions.BodyMeasurementNotFoundException;
import de.oninek.trainmate.api.persistance.TrainMateRepository;

public interface BodyMeasurementRepository extends TrainMateRepository<BodyMeasurementEntity> {

    default BodyMeasurementEntity findByIdOrThrow(long id) {
        return findById(id).orElseThrow(() -> new BodyMeasurementNotFoundException("BodyMeasurement with id " + id + " can't be found"));
    }
}
