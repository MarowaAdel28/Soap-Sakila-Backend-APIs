package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.FilmActor} entity
 */
@Data
public class FilmActorDto extends BaseDto implements Serializable {
    private final FilmActorPKDto filmActorPK;
    private final Date lastUpdate;

    /**
     * A DTO for the {@link gov.iti.jets.entity.FilmActorPK} entity
     */
    @Data
    public static class FilmActorPKDto implements Serializable {
        private final short actorId;
        private final short filmId;
    }
}