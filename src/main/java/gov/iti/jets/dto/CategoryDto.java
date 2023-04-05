package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Category} entity
 */
@Data
public class CategoryDto extends BaseDto implements Serializable {
    private final Short categoryId;
    private final String name;
    private final Date lastUpdate;
}