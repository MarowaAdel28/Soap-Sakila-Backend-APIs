package gov.iti.jets.service;

import gov.iti.jets.dao.ActorDAO;
import gov.iti.jets.dto.ActorDto;
import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.FilmActor;
import gov.iti.jets.mapper.ActorMapper;
import gov.iti.jets.mapper.FilmMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class ActorService {
    private volatile static ActorService actorService;

    private ActorMapper actorMapper;

    private FilmMapper filmMapper;

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

    private ActorService() {
        actorMapper = Mappers.getMapper(ActorMapper.class);
        filmMapper = Mappers.getMapper(FilmMapper.class);
    }

    // get all actors
    public List<ActorDto> getActorList() {
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = actorDAO.getAllActors();
        return actorMapper.toDTOs(actors);
    }

    // get actor by id
    public ActorDto getActorById(Short id) {
        ActorDAO actorDAO = new ActorDAO();
        Actor actor = actorDAO.get(id);
        return actorMapper.toDto(actor);
    }

    // search actor by full name
    public  List<ActorDto> searchActorByName(String name) {
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = actorDAO.searchActorByName(name);
        return actorMapper.toDTOs(actors);
    }

    // get list of actor films by actor id
    public List<FilmDto> getActorFilmList(short id) {
        ActorDAO actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmList(id);
        List<FilmDto> filmDtoList = filmActors.stream().map(FilmActor::getFilm).map(filmMapper::toDto).toList();
        return filmDtoList;
    }

    // get list of actor films by actor id and specific language
    public List<FilmDto> getActorFilmListByLanguage(short id, String language) {
        ActorDAO actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByLanguage(id, language);
        List<FilmDto> filmDtoList = filmActors.stream().map(FilmActor::getFilm).map(filmMapper::toDto).toList();
        return filmDtoList;
    }
    // get list of actor films by actor id and specific rating
    public List<FilmDto> getActorFilmListByRating(short id, String rating) {
        ActorDAO actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByRating(id, rating);
        List<FilmDto> filmDtoList = filmActors.stream().map(FilmActor::getFilm).map(filmMapper::toDto).toList();
        return filmDtoList;
    }

//    public Actor getActorByName(String fname, String lname) {
//        actorDAO = new ActorDAO();
//        return actorDAO.getActorByName(fname,lname);
//    }

    // get list of actor films by actor first and last name

    public List<FilmDto> getActorFilmList(String fname,String lname) {
        ActorDAO actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmList(fname,lname);
        List<FilmDto> filmDtoList = filmActors.stream().map(FilmActor::getFilm).map(filmMapper::toDto).toList();
        return filmDtoList;
    }
    // get list of actor films by actor first and last name and specific language
    public List<FilmDto> getActorFilmListByLanguage(String fname, String lname, String language) {
        ActorDAO actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByLanguage(fname,lname, language);
        List<FilmDto> filmDtoList = filmActors.stream().map(FilmActor::getFilm).map(filmMapper::toDto).toList();
        return filmDtoList;
    }
    // get list of actor films by actor first and last name and specific rating
    public List<FilmDto> getActorFilmListByRating(String fname, String lname, String rating) {
        ActorDAO actorDAO = new ActorDAO();
        List<FilmActor> filmActors = actorDAO.getActorFilmListByRating(fname,lname, rating);
        List<FilmDto> filmDtoList = filmActors.stream().map(FilmActor::getFilm).map(filmMapper::toDto).toList();
        return filmDtoList;
    }

    // get count of actor film list
    public int getActorFilmCount(short id) {
        ActorDAO actorDAO = new ActorDAO();
        return actorDAO.getActorFilmCount(id);
    }
    // get count of actor films by actor id and specific language
    public int getActorFilmCountByLanguage(short id, String language) {
        ActorDAO actorDAO = new ActorDAO();
        return actorDAO.getActorFilmCountByLanguage(id, language);
    }
    // get count of actor films by actor id and specific rating
    public int getActorFilmCountByRating(short id, String rating) {
        ActorDAO actorDAO = new ActorDAO();
        return actorDAO.getActorFilmCountByRating(id, rating);
    }



}
