package gov.iti.jets.api.soap.services;

import gov.iti.jets.dao.ActorDAO;
import gov.iti.jets.dto.ActorDto;
import gov.iti.jets.dto.FilmActorDto;
import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.FilmActor;
import gov.iti.jets.service.ActorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class ActorWebService {
    private ActorService actorService = ActorService.getInstance();

    public String getActorList() {

        return actorService.getActorList().get(0).getFirstName();
    }
    public ActorDto getActorById(Short actorId) {
        return actorService.getActorById(actorId);
    }

    public  List<ActorDto> searchActorByName(String name) {
        return  actorService.searchActorByName(name);
    }

    public List<FilmActorDto> getActorFilmList(short id) {
        return actorService.getActorFilmList(id);
    }
    public List<FilmActorDto> getActorFilmListByLanguage(short id, String language) {
        return actorService.getActorFilmListByLanguage(id, language);
    }
    public List<FilmActorDto> getActorFilmListByRating(short id,String rating) {
        return actorService.getActorFilmListByRating(id,rating);
    }

    public List<FilmActorDto> getActorFilmList(String fname, String lname) {
        return actorService.getActorFilmList(fname,lname);
    }
    public List<FilmActorDto> getActorFilmListByLanguage(String fname, String lname, String language) {
        return actorService.getActorFilmListByLanguage(fname,lname, language);
    }
    public List<FilmActorDto> getActorFilmListByRating(String fname, String lname,String rating) {
        return actorService.getActorFilmListByRating(fname,lname,rating);
    }

    public int getActorFilmCount(short id) {
        return actorService.getActorFilmCount(id);
    }
    public int getActorFilmCountByLanguage(short id, String language) {
        return actorService.getActorFilmCountByLanguage(id, language);
    }
    public int getActorFilmCountByRating(short id,String rating) {
        return actorService.getActorFilmCountByRating(id,rating);
    }
}
