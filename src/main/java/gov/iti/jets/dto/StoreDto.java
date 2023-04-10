package gov.iti.jets.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Store} entity
 */
@Data
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto implements Serializable {
    private Short storeId;
    private Date lastUpdate;
    private String storeAddress;
    private String managerName;
}