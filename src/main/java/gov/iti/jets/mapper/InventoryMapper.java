package gov.iti.jets.mapper;

import gov.iti.jets.dto.InventoryDto;
import gov.iti.jets.entity.Inventory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface InventoryMapper {
    Inventory toEntity(InventoryDto inventoryDto);

    InventoryDto toDto(Inventory inventory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryDto inventoryDto, @MappingTarget Inventory inventory);
}