package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.service.ActorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("actor_films")
public class ActorFilmResourc {

    private ActorService actorService;
    public ActorFilmResourc() {
        actorService = ActorService.getInstance();
    }

    @GET
    @Path("{id:[0-9]+}")
    public List<FilmDto> gatAllFilms(@PathParam("id") Short id) {
        return actorService.getActorFilmList(id);
    }

    @GET
    @Path("filter")
    public List<FilmDto> getFilmListByRating(@QueryParam("actorId") Short id, @QueryParam("rating") String rate,
                                             @QueryParam("language") String language) {
        if(rate!=null) {
            return actorService.getActorFilmListByRating(id,rate);
        }
        if(language!=null) {
            return actorService.getActorFilmListByLanguage(id,language);
        }
        return null;
    }

    // sumation

//    @GET
//    @Path("filter/language")
//    public List<FilmDto> getFilmListByLanguage(@QueryParam("actorId") Short id, @QueryParam("language") String language) {
//        return actorService.getActorFilmListByLanguage(id,language);
//    }
}
