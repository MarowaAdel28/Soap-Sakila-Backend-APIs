package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Language} entity
 */
@Data
public class LanguageDto extends BaseDto implements Serializable {
    private final Short languageId;
    private final String name;
    private final Date lastUpdate;
}