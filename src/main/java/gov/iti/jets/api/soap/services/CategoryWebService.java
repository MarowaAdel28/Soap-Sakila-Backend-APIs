package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.CategoryDto;
import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.service.CategoryService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CategoryWebService {

    private CategoryService categoryService = CategoryService.getInstance();

    @WebMethod(operationName = "CategoryById")
    public CategoryDto getCategoryById(@WebParam(name = "categoryId") short id) {
        return categoryService.getCategoryById(id);
    }

    @WebMethod(operationName = "AllCategories")
    public List<CategoryDto> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @WebMethod(operationName = "searchByName")
    public List<CategoryDto> searchCategoryByName(@WebParam(name = "categoryName") String name) {
        return categoryService.searchCategoryByName(name);
    }

    @WebMethod(operationName = "CategoryFilms")
    public List<FilmDto> getCategoryFilms(@WebParam(name = "categoryId") short categoryId) {
        return categoryService.getCategoryFilms(categoryId);
    }

    @WebMethod(operationName = "NoOfCategoryFilms")

    public int getCategoryFilmsCount(@WebParam(name = "categoryId") short categoryId) {
        return categoryService.getCategoryFilmsCount(categoryId);
    }

    public boolean addCategory(@WebParam(name = "categoryName") String categoryName) {
        return categoryService.addCategory(categoryName);
    }

    public boolean editCategory(@WebParam(name = "categoryId") Short categoryId, @WebParam(name = "categoryName") String categoryName) {
        return categoryService.editCategory(categoryId,categoryName);
    }
}
