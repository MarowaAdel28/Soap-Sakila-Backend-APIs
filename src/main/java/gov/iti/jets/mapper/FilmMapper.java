package gov.iti.jets.mapper;

import gov.iti.jets.dto.FilmActorDto;
import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.entity.Film;
import gov.iti.jets.entity.FilmActor;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmMapper {
    Film toEntity(FilmDto filmDto);

    FilmDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmDto filmDto, @MappingTarget Film film);

    default ArrayList<FilmDto> toDTOs(Collection<Film> films) {
        return films.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<FilmDto>::new));
    }

    default ArrayList<Film> toEntities(Collection<FilmDto> filmDtos) {
        return filmDtos.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<Film>::new));
    }
}