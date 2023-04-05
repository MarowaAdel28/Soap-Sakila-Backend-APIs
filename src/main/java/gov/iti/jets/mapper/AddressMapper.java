package gov.iti.jets.mapper;

import gov.iti.jets.dto.AddressDto;
import gov.iti.jets.entity.Address;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface AddressMapper {
    Address toEntity(AddressDto addressDto);

    AddressDto toDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(AddressDto addressDto, @MappingTarget Address address);
}