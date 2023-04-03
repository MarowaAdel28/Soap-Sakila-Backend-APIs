package gov.iti.jets.service;

import gov.iti.jets.dao.ActorDAO;
import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.FilmActor;

import java.util.List;

public class ActorService {
    private volatile static ActorService actorService;

    private ActorDAO actorDAO;
    public static ActorService getInstance() {
        if (actorService == null) {
            synchronized (ActorService.class) {
                if (actorService == null) {
                    actorService = new ActorService();
                }
            }
        }
        return actorService;
    }

    // get all actors
    public List<Actor> getActorList() {
        actorDAO = new ActorDAO();
        return actorDAO.getAllActors();
    }

    // get actor by id
    public Actor getActorById(Short id) {
        actorDAO = new ActorDAO();
        return actorDAO.get(id);
    }

    // search actor by full name
    public  List<Actor> searchActorByName(String name) {
        actorDAO = new ActorDAO();
        return actorDAO.searchActorByName(name);
    }

    // get list of actor films by actor id
    public List<FilmActor> getActorFilmList(short id) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmList(id);
    }
    // get list of actor films by actor id and specific language
    public List<FilmActor> getActorFilmListByLanguage(short id, String language) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmListByLanguage(id, language);
    }
    // get list of actor films by actor id and specific rating
    public List<FilmActor> getActorFilmListByRating(short id, String rating) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmListByRating(id, rating);
    }

//    public Actor getActorByName(String fname, String lname) {
//        actorDAO = new ActorDAO();
//        return actorDAO.getActorByName(fname,lname);
//    }

    // get list of actor films by actor first and last name

    public List<FilmActor> getActorFilmList(String fname,String lname) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmList(fname,lname);
    }
    // get list of actor films by actor first and last name and specific language
    public List<FilmActor> getActorFilmListByLanguage(String fname, String lname, String language) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmListByLanguage(fname,lname, language);
    }
    // get list of actor films by actor first and last name and specific rating
    public List<FilmActor> getActorFilmListByRating(String fname, String lname, String rating) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmListByRating(fname,lname, rating);
    }

}
