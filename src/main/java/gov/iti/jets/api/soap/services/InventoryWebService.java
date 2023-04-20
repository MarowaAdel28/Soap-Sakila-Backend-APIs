package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.dto.InventoryDto;
import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.service.InventoryService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class InventoryWebService {

    private InventoryService inventoryService;

    public InventoryWebService() {
        inventoryService = InventoryService.getInstance();
    }

    @WebMethod(operationName = "InventoryById")
    public InventoryDto getById(@WebParam(name = "inventoryId") Short id) {
        return inventoryService.getById(id);
    }

    @WebMethod(operationName = "AllInventories")
    public List<InventoryDto> getAll() {
        return inventoryService.getAll();
    }

    @WebMethod(operationName = "InventoryByFilm")
    public List<InventoryDto> getByFilm(@WebParam(name = "filmId") Integer filmId) {
        return inventoryService.getByFilm(filmId);
    }

    @WebMethod(operationName = "InventoryByStore")
    public List<InventoryDto> getByStore(@WebParam(name = "storeId") Short storeId) {
        return inventoryService.getByStore(storeId);
    }

    @WebMethod(operationName = "StoreFilmList")
    public List<FilmDto> getStoreFilms(@WebParam(name = "storeId") Short storeId) {
        return inventoryService.getStoreFilms(storeId);
    }

    @WebMethod(operationName = "DeleteInventory")
    public boolean deleteInventory(@WebParam(name = "inventoryId") Short id) {
        return inventoryService.deleteInventory(id);
    }

}
