package gov.iti.jets.mapper;

import gov.iti.jets.dto.CustomerInfoDto;
import gov.iti.jets.entity.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CustomerInfoMapper {
    Customer toEntity(CustomerInfoDto customerInfoDto);

    CustomerInfoDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerInfoDto customerInfoDto, @MappingTarget Customer customer);
}