package gov.iti.jets.mapper;

import gov.iti.jets.dto.StoreDto;
import gov.iti.jets.entity.Store;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface StoreMapper {
    Store toEntity(StoreDto storeDto);

    StoreDto toDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreDto storeDto, @MappingTarget Store store);
}