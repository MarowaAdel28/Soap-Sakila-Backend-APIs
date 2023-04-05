package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Country} entity
 */
@Data
public class CountryDto extends BaseDto implements Serializable {
    private final Short countryId;
    private final String country;
    private final Date lastUpdate;
}