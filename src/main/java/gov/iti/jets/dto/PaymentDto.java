package gov.iti.jets.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Payment} entity
 */
@Data
public class PaymentDto extends BaseDto implements Serializable {
    private final Short paymentId;
    private final BigDecimal amount;
    private final Date paymentDate;
    private final Date lastUpdate;
}