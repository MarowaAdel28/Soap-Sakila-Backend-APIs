package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.CityDto;
import gov.iti.jets.service.CityService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("cities")
public class CityResource {

    private CityService cityService;

    public CityResource() {
        cityService = CityService.getInstance();
    }

    @GET
    public List<CityDto> getAll() {
        return cityService.getAllCities();
    }

    @GET
    @Path("{id:[0-9]+}")
    public CityDto getById(@PathParam("id") short id) {
        return cityService.getCityById(id);
    }
}
