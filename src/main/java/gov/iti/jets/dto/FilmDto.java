package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Film} entity
 */
@Data
public class FilmDto extends BaseDto implements Serializable {
    private final Short filmId;
    private final String title;
    private final String description;
    private final Date releaseYear;
    private final short rentalDuration;
    private final BigDecimal rentalRate;
    private final Short length;
    private final BigDecimal replacementCost;
    private final String rating;
    private final String specialFeatures;
    private final Date lastUpdate;
}