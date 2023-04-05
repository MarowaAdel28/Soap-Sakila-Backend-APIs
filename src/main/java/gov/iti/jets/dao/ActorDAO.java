package gov.iti.jets.dao;

import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.FilmActor;
import jakarta.persistence.Query;

import java.util.List;

public class ActorDAO extends BaseDAO<Actor>{

    public ActorDAO() {
        super(Actor.class);
    }

    public List<Actor> getAllActors() {
        String queryString = "from Actor a ";
        Query q = entityManager.createQuery(queryString);
        return (List<Actor>) q.getResultList();
    }
    public List<Actor> searchActorByName(String name) {
        String queryString = "from Actor a where a.firstName like :fname or a.lastName like :lname";
        Query q = entityManager.createQuery(queryString)
                .setParameter("fname", name)
                .setParameter("lname", name);
        return (List<Actor>) q.getResultList();
    }

    public Actor getActorByName(String fname, String lname) {
        String queryString = "from Actor a where a.firstName = :fname and a.lastName = :lname";
        Query q = entityManager.createQuery(queryString)
                .setParameter("fname", fname)
                .setParameter("lname", lname);
        return (Actor) q.getSingleResult();
    }

    public List<FilmActor> getActorFilmList(short actorId) {
        Actor actor = get(actorId);
        return actor.getFilmActorList();
    }

    public List<FilmActor> getActorFilmListByLanguage(short actorId, String languageName) {
        Actor actor = get(actorId);
        List<FilmActor> filmActorList = actor.getFilmActorList().stream()
                .filter((film)->
                    film.getFilm().getLanguageId().getName().equals(languageName)
                ).toList();
        return filmActorList;
    }

    public List<FilmActor> getActorFilmListByRating(short actorId, String rate) {
        Actor actor = get(actorId);
        List<FilmActor> filmActorList = actor.getFilmActorList().stream()
                .filter((film)->
                        film.getFilm().getRating().equals(rate)
                ).toList();
        return filmActorList;
    }

    public List<FilmActor> getActorFilmList(String fname, String lname) {
        Actor actor = getActorByName(fname,lname);
        return actor.getFilmActorList();
    }

    public List<FilmActor> getActorFilmListByLanguage(String fname, String lname, String languageName) {
        Actor actor = getActorByName(fname,lname);
        List<FilmActor> filmActorList = actor.getFilmActorList().stream()
                .filter((film)->
                        film.getFilm().getLanguageId().getName().equals(languageName)
                ).toList();
        return filmActorList;
    }

    public List<FilmActor> getActorFilmListByRating(String fname, String lname, String rate) {
        Actor actor = getActorByName(fname,lname);
        List<FilmActor> filmActorList = actor.getFilmActorList().stream()
                .filter((film)->
                        film.getFilm().getRating().equals(rate)
                ).toList();
        return filmActorList;
    }

    public int getActorFilmCount(short actorId) {
        Actor actor = get(actorId);
        return actor.getFilmActorList().size();
    }

    public int getActorFilmCountByLanguage(short actorId, String languageName) {
        Actor actor = get(actorId);
        List<FilmActor> filmActorList = actor.getFilmActorList().stream()
                .filter((film)->
                        film.getFilm().getLanguageId().getName().equals(languageName)
                ).toList();
        return filmActorList.size();
    }

    public int getActorFilmCountByRating(short actorId, String rate) {
        Actor actor = get(actorId);
        List<FilmActor> filmActorList = actor.getFilmActorList().stream()
                .filter((film)->
                        film.getFilm().getRating().equals(rate)
                ).toList();
        return filmActorList.size();
    }
}
