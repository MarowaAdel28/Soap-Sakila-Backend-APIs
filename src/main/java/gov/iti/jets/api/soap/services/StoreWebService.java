package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.*;
import gov.iti.jets.service.StoreService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class StoreWebService {

    private StoreService storeService = StoreService.getInstance();

    @WebMethod(operationName = "StoreById")
    public StoreDto getStoreById(@WebParam(name = "StoreId") short id) {
        return storeService.getStoreById(id);
    }

    @WebMethod(operationName = "AllStores")
    public List<StoreDto> getAllStores() {
        return storeService.getAllStores();
    }

    @WebMethod(operationName = "StoreCustomerList")
    public List<CustomerInfoDto> getStoreCustomerList(@WebParam(name = "StoreId") Short id) {
        return storeService.getStoreCustomerList(id);
    }

    @WebMethod(operationName = "StoreStaffList")
    public List<StaffDto> getStoreStaffList(@WebParam(name = "StoreId") Short id) {
        return storeService.getStoreStaffList(id);
    }

    @WebMethod(operationName = "StoreInventoryList")
    public List<InventoryDto> getStoreInventoryList(@WebParam(name = "StoreId") Short storeId) {
        return storeService.getStoreInventoryList(storeId);
    }

    public boolean addStore(@WebParam(name = "store") StoreFormDto storeFormDto) {
        return storeService.addStore(storeFormDto);
    }

    public boolean editStore(@WebParam(name = "storeId") Short storeId, @WebParam(name = "store") StoreFormDto storeFormDto) {
        return storeService.editStore(storeId,storeFormDto);
    }

    @WebMethod(operationName = "DeleteStore")
    public boolean deleteStore(@WebParam(name = "storeId") Short id) {
        return storeService.deleteStore(id);
    }
}
