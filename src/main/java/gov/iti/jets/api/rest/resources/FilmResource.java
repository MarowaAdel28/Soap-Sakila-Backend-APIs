package gov.iti.jets.api.rest.resources;

import gov.iti.jets.service.FilmService;
import gov.iti.jets.views.NicerButSlowerFilmList;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("films")
public class FilmResource {

    FilmService filmService;

    public FilmResource() {
        filmService = FilmService.getFilmServiceInstance();
    }

    @GET
    @Path("{id:[0-9]+}")
    public NicerButSlowerFilmList getFilmInfoById(@PathParam("id") short id) {
        return filmService.getFilm(id);
    }
}
