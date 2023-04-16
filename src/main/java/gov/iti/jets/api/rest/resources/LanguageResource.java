package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.LanguageDto;
import gov.iti.jets.service.LanguageService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("languages")
public class LanguageResource {

    private LanguageService languageService;

    public LanguageResource() {
        languageService = LanguageService.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LanguageDto> getAll() {
        return languageService.getAll();
    }

    @GET
    @Path("{id:[0-9]+}")
    public LanguageDto getById(@PathParam("id") Short id) {
        return languageService.getById(id);
    }
}
