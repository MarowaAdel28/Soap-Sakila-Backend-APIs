package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.CityDto;
import gov.iti.jets.service.CityService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CityWebService {
    CityService cityService = CityService.getInstance();

    @WebMethod(operationName = "CityById")
    public CityDto getCityById(@WebParam(name = "cityId") short id) {
        return cityService.getCityById(id);
    }

    @WebMethod(operationName = "AllCities")
    public List<CityDto> getAllCities() {
        return cityService.getAllCities();
    }
}
