package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.CityDto;
import gov.iti.jets.dto.CountryDto;
import gov.iti.jets.service.CityService;
import gov.iti.jets.service.CountryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("cities")
public class CountryResource {

    private CountryService countryService;

    public CountryResource() {
        countryService = CountryService.getInstance();
    }

    @GET
    public List<CountryDto> getAll() {
        return countryService.getAllCountries();
    }

    @GET
    @Path("{id:[0-9]+}")
    public CountryDto getById(@PathParam("id") short id) {
        return countryService.getCountryById(id);
    }

    @GET
    @Path("cities")
    public List<CityDto> getCountryCityList(@QueryParam("countryId") short id) {
        return countryService.getCountryCityList(id);
    }
}
