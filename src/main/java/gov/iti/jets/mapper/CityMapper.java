package gov.iti.jets.mapper;

import gov.iti.jets.dto.CityDto;
import gov.iti.jets.entity.City;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CityMapper {
    City toEntity(CityDto cityDto);

    CityDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityDto cityDto, @MappingTarget City city);
}