package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Rental} entity
 */
@Data
public class RentalDto extends BaseDto implements Serializable {
    private final Integer rentalId;
    private final Date rentalDate;
    private final Date returnDate;
    private final Date lastUpdate;
}