package gov.iti.jets.mapper;

import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.entity.Film;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmMapper {
    Film toEntity(FilmDto filmDto);

    FilmDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmDto filmDto, @MappingTarget Film film);
}