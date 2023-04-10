package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.CityDto;
import gov.iti.jets.dto.CountryDto;
import gov.iti.jets.service.CountryService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CountryWebService {

    private CountryService countryService = CountryService.getInstance();

    @WebMethod(operationName = "AllCountries")
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    @WebMethod(operationName = "CountryById")
    public CountryDto getCountryById(@WebParam(name = "countryId") short id) {
        return countryService.getCountryById(id);
    }

    @WebMethod(operationName = "CountryCityList")
    public List<CityDto> getCountryCityList(@WebParam(name = "countryId") short countryId) {
        return countryService.getCountryCityList(countryId);
    }
}
