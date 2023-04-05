package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Store} entity
 */
@Data
public class StoreDto extends BaseDto implements Serializable {
    private final Short storeId;
    private final Date lastUpdate;
}