package gov.iti.jets.mapper;

import gov.iti.jets.dto.ActorFormDto;
import gov.iti.jets.entity.Actor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface ActorFormMapper {
    Actor toEntity(ActorFormDto actorFormDto);

    ActorFormDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorFormDto actorFormDto, @MappingTarget Actor actor);
}