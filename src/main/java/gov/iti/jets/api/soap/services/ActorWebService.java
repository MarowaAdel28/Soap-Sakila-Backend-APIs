package gov.iti.jets.api.soap.services;

import gov.iti.jets.dao.ActorDAO;
import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.FilmActor;
import gov.iti.jets.service.ActorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class ActorWebService {
    private ActorService actorService = ActorService.getInstance();

    public List<Actor> getActorList() {

        return actorService.getActorList();
    }
    public Actor getActorById(Short actorId) {
        Actor actor = actorService.getActorById(actorId);
//        System.out.println(actor);
        return actor;
    }

    public  List<Actor> searchActorByName(String name) {
        return  actorService.searchActorByName(name);
    }

    public List<FilmActor> getActorFilmList(short id) {
        return actorService.getActorFilmList(id);
    }
    public List<FilmActor> getActorFilmListByLanguage(short id, String language) {
        return actorService.getActorFilmListByLanguage(id, language);
    }
    public List<FilmActor> getActorFilmListByRating(short id,String rating) {
        return actorService.getActorFilmListByRating(id,rating);
    }

//    public Actor getActorByName(String fname, String lname) {
//        Actor actor = actorService.getActorByName(fname,lname);
////        System.out.println(actor);
//        return actor;
//    }
    public List<FilmActor> getActorFilmList(String fname, String lname) {
        return actorService.getActorFilmList(fname,lname);
    }
    public List<FilmActor> getActorFilmListByLanguage(String fname, String lname, String language) {
        return actorService.getActorFilmListByLanguage(fname,lname, language);
    }
    public List<FilmActor> getActorFilmListByRating(String fname, String lname,String rating) {
        return actorService.getActorFilmListByRating(fname,lname,rating);
    }

//
//    public String hello() {
//        return "hello";
//    }
}
