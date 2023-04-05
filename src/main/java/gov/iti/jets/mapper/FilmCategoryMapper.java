package gov.iti.jets.mapper;

import gov.iti.jets.dto.FilmCategoryDto;
import gov.iti.jets.entity.FilmCategory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmCategoryPKMapper.class})
public interface FilmCategoryMapper {
    FilmCategory toEntity(FilmCategoryDto filmCategoryDto);

    FilmCategoryDto toDto(FilmCategory filmCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory partialUpdate(FilmCategoryDto filmCategoryDto, @MappingTarget FilmCategory filmCategory);
}