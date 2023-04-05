package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Customer} entity
 */
@Data
public class CustomerDto extends BaseDto implements Serializable {
    private final Short customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final boolean active;
    private final Date createDate;
    private final Date lastUpdate;
}