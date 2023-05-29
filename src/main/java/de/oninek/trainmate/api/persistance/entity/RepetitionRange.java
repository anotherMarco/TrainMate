package de.oninek.trainmate.api.persistance.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class RepetitionRange {

    private int minRepetitions;
    private int maxRepetitions;
}
