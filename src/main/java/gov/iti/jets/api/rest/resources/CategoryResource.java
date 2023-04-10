package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.CategoryDto;
import gov.iti.jets.service.CategoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("categories")
public class CategoryResource {

    private CategoryService categoryService;

    public CategoryResource() {
        categoryService = CategoryService.getInstance();
    }

    @GET
    public List<CategoryDto> getAll() {
        return categoryService.getAllCategories();
    }

    @GET
    @Path("{id:[0-9]+}")
    public CategoryDto getById(@PathParam("id") short id) {
        return categoryService.getCategoryById(id);
    }

    @GET
    @Path("search")
    public List<CategoryDto> searchByName(@QueryParam("name") String name) {
        return categoryService.searchCategoryByName(name);
    }

}
