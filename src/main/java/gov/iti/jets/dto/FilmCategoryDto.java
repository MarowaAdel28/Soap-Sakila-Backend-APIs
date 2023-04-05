package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.FilmCategory} entity
 */
@Data
public class FilmCategoryDto extends BaseDto implements Serializable {
    private final FilmCategoryPKDto filmCategoryPK;
    private final Date lastUpdate;

    /**
     * A DTO for the {@link gov.iti.jets.entity.FilmCategoryPK} entity
     */
    @Data
    public static class FilmCategoryPKDto implements Serializable {
        private final short filmId;
        private final short categoryId;
    }
}