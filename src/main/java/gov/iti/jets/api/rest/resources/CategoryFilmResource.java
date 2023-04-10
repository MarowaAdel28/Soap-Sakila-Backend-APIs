package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.entity.Film;
import gov.iti.jets.service.CategoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("category_films")
public class CategoryFilmResource {

    private CategoryService categoryService;

    public CategoryFilmResource() {
        categoryService = CategoryService.getInstance();
    }

    @GET
    @Path("{id:[0-9]+}")
    public List<FilmDto> getCategoryFilms(@PathParam("id") short id) {
        return categoryService.getCategoryFilms(id);
    }

    // count
}