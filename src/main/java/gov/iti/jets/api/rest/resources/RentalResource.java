package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.service.RentalService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("rentals")
public class RentalResource {

    private RentalService rentalService;

    public RentalResource() {
        rentalService = RentalService.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentalDto> getAll() {
        return rentalService.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id:[0-9]+}")
    public RentalDto getById(@PathParam("id") Short id) {
        return rentalService.getById(id);
    }
}
