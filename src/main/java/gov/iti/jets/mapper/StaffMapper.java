package gov.iti.jets.mapper;

import gov.iti.jets.dto.StaffDto;
import gov.iti.jets.entity.Staff;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface StaffMapper {
    Staff toEntity(StaffDto staffDto);

    StaffDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffDto staffDto, @MappingTarget Staff staff);
}