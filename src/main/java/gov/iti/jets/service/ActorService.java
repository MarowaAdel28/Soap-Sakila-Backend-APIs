package gov.iti.jets.service;

import gov.iti.jets.dao.ActorDAO;
import gov.iti.jets.dto.ActorDto;
import gov.iti.jets.dto.FilmActorDto;
import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.FilmActor;
import gov.iti.jets.mapper.ActorMapper;
import gov.iti.jets.mapper.FilmActorMapper;

import java.util.List;

public class ActorService {
    private volatile static ActorService actorService;

    private ActorMapper actorMapper;

    private FilmActorMapper filmActorMapper;

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
    public List<ActorDto> getActorList() {
        actorDAO = new ActorDAO();
        List<Actor> actors = actorDAO.getAllActors();
        return actorMapper.toDTOs(actors);
    }

    // get actor by id
    public ActorDto getActorById(Short id) {
        actorDAO = new ActorDAO();
        Actor actor = actorDAO.get(id);
        return actorMapper.toDto(actor);
    }

    // search actor by full name
    public  List<ActorDto> searchActorByName(String name) {
        actorDAO = new ActorDAO();
        List<Actor> actors = actorDAO.searchActorByName(name);
        return actorMapper.toDTOs(actors);
    }

    // get list of actor films by actor id
    public List<FilmActorDto> getActorFilmList(short id) {
        actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmList(id);
        return filmActorMapper.toDTOs(filmActors);
    }

    // get list of actor films by actor id and specific language
    public List<FilmActorDto> getActorFilmListByLanguage(short id, String language) {
        actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByLanguage(id, language);
        return filmActorMapper.toDTOs(filmActors);
    }
    // get list of actor films by actor id and specific rating
    public List<FilmActorDto> getActorFilmListByRating(short id, String rating) {
        actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByRating(id, rating);
        return filmActorMapper.toDTOs(filmActors);
    }

//    public Actor getActorByName(String fname, String lname) {
//        actorDAO = new ActorDAO();
//        return actorDAO.getActorByName(fname,lname);
//    }

    // get list of actor films by actor first and last name

    public List<FilmActorDto> getActorFilmList(String fname,String lname) {
        actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmList(fname,lname);
        return filmActorMapper.toDTOs(filmActors);
    }
    // get list of actor films by actor first and last name and specific language
    public List<FilmActorDto> getActorFilmListByLanguage(String fname, String lname, String language) {
        actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByLanguage(fname,lname, language);
        return filmActorMapper.toDTOs(filmActors);
    }
    // get list of actor films by actor first and last name and specific rating
    public List<FilmActorDto> getActorFilmListByRating(String fname, String lname, String rating) {
        actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByRating(fname,lname, rating);
        return filmActorMapper.toDTOs(filmActors);
    }

    // get count of actor film list
    public int getActorFilmCount(short id) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmCount(id);
    }
    // get count of actor films by actor id and specific language
    public int getActorFilmCountByLanguage(short id, String language) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmCountByLanguage(id, language);
    }
    // get count of actor films by actor id and specific rating
    public int getActorFilmCountByRating(short id, String rating) {
        actorDAO = new ActorDAO();
        return actorDAO.getActorFilmCountByRating(id, rating);
    }

}
