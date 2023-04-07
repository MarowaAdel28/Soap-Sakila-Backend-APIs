package gov.iti.jets.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.entity.Actor} entity
 */
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddingActorDto implements Serializable {
    private String firstName;
    private String lastName;
}