package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Actor} entity
 */
@Data
public class ActorDto extends BaseDto implements Serializable {
    private final Short actorId;
    private final String firstName;
    private final String lastName;
    private final Date lastUpdate;
}