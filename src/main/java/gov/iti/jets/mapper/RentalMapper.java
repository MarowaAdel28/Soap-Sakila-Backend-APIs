package gov.iti.jets.mapper;

import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.entity.Rental;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface RentalMapper {
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalDto rentalDto, @MappingTarget Rental rental);
}