package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.City} entity
 */
@Data
public class CityDto extends BaseDto implements Serializable {
    private final Short cityId;
    private final String city;
    private final Date lastUpdate;
}