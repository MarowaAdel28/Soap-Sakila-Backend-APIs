package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.entity.FilmText} entity
 */
@Data
public class FilmTextDto extends BaseDto implements Serializable {
    private final Short filmId;
    private final String title;
    private final String description;
}