package gov.iti.jets.service;

import gov.iti.jets.dao.ActorDAO;
import gov.iti.jets.dao.CategoryDAO;
import gov.iti.jets.dto.CategoryDto;
import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.entity.*;
import gov.iti.jets.mapper.ActorMapper;
import gov.iti.jets.mapper.CategoryMapper;
import gov.iti.jets.mapper.FilmActorMapper;
import gov.iti.jets.mapper.FilmMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

public class CategoryService {
    private volatile static CategoryService categoryService;

    private ActorMapper actorMapper;

    private FilmActorMapper filmActorMapper;

    private CategoryMapper categoryMapper;

    private FilmMapper filmMapper;
    public static CategoryService getInstance() {
        if (categoryService == null) {
            synchronized (ActorService.class) {
                if (categoryService == null) {
                    categoryService = new CategoryService();
                }
            }
        }
        return categoryService;
    }

    private CategoryService() {
        actorMapper = Mappers.getMapper(ActorMapper.class);
        filmActorMapper = Mappers.getMapper(FilmActorMapper.class);
        categoryMapper = Mappers.getMapper(CategoryMapper.class);
        filmMapper = Mappers.getMapper(FilmMapper.class);
    }

    public CategoryDto getCategoryById(short id) {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.get(id);
        return categoryMapper.toDto(category);
    }

    public List<CategoryDto> getAllCategories() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategories();
        return categoryMapper.toDTOs(categories);
    }

    public List<CategoryDto> searchCategoryByName(String name) {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.searchByCategoryName(name);
        return categoryMapper.toDTOs(categories);
    }

    public List<FilmDto> getCategoryFilms(short categoryId) {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.get(categoryId);
        List<FilmCategory> filmCategoryList = category.getFilmCategoryList();
        List<FilmDto> filmDtoList = filmCategoryList.stream().map(FilmCategory::getFilm).map((film -> filmMapper.toDto(film))).toList();
        return filmDtoList;
    }
    public int getCategoryFilmsCount(short categoryId) {
        return getCategoryFilms(categoryId).size();
    }


//    public List<FilmDto> getCategoryFilmsForActor(short categoryId, short actorId) {
//        ActorDAO actorDAO = new ActorDAO();
//        Actor actor = actorDAO.get(actorId);
//        List<FilmActor> filmActorList = actor.getFilmActorList();
//        List<Film> filmList = filmActorList.stream().map(FilmActor::getFilm).filter(Film::)
//                .toList();
//        List<FilmDto> filmDtoList = filmMapper.toDTOs(filmList);
//        return filmDtoList;
//    }

    private Category getCategory(Film film, short categoryId) {
        List<FilmCategory> filmCategoryList = film.getFilmCategoryList();
        Optional<Category> optionalCategory = filmCategoryList
                .stream()
                .map(FilmCategory::getCategory)
                .filter((category)->category.getCategoryId()==categoryId)
                .findFirst();
        if(optionalCategory.isPresent()) return optionalCategory.get();
        return null;
    }
}
