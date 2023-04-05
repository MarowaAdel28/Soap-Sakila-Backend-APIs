package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Inventory} entity
 */
@Data
public class InventoryDto extends BaseDto implements Serializable {
    private final Integer inventoryId;
    private final Date lastUpdate;
}