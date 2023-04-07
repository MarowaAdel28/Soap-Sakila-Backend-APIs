package gov.iti.jets.mapper;

import gov.iti.jets.dto.AddingActorDto;
import gov.iti.jets.entity.Actor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface AddingActorMapper {
    Actor toEntity(AddingActorDto addingActorDto);

    AddingActorDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(AddingActorDto addingActorDto, @MappingTarget Actor actor);
}