package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Staff} entity
 */
@Data
public class StaffDto extends BaseDto implements Serializable {
    private final Short staffId;
    private final String firstName;
    private final String lastName;
    private final byte[] picture;
    private final String email;
    private final boolean active;
    private final String username;
    private final String password;
    private final Date lastUpdate;
}