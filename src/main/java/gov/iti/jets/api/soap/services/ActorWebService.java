package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.ActorDto;
import gov.iti.jets.dto.ActorFormDto;
import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.service.ActorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class ActorWebService {
    private ActorService actorService = ActorService.getInstance();

    @WebMethod(operationName = "AllActors")
    public List<ActorDto> getActorList() {
        return actorService.getActorList();
    }
    @WebMethod(operationName = "ActorById")
    public ActorDto getActorById(@WebParam(name = "actorId") Short actorId) {
        return actorService.getActorById(actorId);
    }

    @WebMethod(operationName = "searchByName")
    public  List<ActorDto> searchActorByName(@WebParam(name = "actorName")String name) {
        return  actorService.searchActorByName(name);
    }

    @WebMethod(operationName = "AllActorFilms")
    public List<FilmDto> getActorFilmList(@WebParam(name = "actorId") short id) {
        return actorService.getActorFilmList(id);
    }
    @WebMethod(operationName = "ActorFilmsByLanguage")
    public List<FilmDto> getActorFilmListByLanguage(@WebParam(name = "actorId") short id, @WebParam(name = "language")String language) {
        return actorService.getActorFilmListByLanguage(id, language);
    }
    @WebMethod(operationName = "ActorFilmsByRating")
    public List<FilmDto> getActorFilmListByRating(@WebParam(name = "actorId") short id, @WebParam(name = "rate") String rating) {
        return actorService.getActorFilmListByRating(id,rating);
    }

    @WebMethod(operationName = "NoOfFilms")
    public int getActorFilmCount(@WebParam(name = "actorId") short id) {
        return actorService.getActorFilmCount(id);
    }
    @WebMethod(operationName = "NoOfFilmsByLanguage")
    public int getActorFilmCountByLanguage(@WebParam(name = "actorId") short id, @WebParam(name = "language") String language) {
        return actorService.getActorFilmCountByLanguage(id, language);
    }
    @WebMethod(operationName = "NoOfFilmsByRating")
    public int getActorFilmCountByRating(@WebParam(name = "actorId") short id, @WebParam(name = "rate") String rating) {
        return actorService.getActorFilmCountByRating(id,rating);
    }

    @WebMethod(operationName = "AddNewActor")
    public boolean addActor(@WebParam(name = "ActorObject") ActorFormDto actorDto) {
        return actorService.addActor(actorDto);
    }

    @WebMethod(operationName = "EditActor")
    public boolean editActor(@WebParam(name = "ActorId")short id, @WebParam(name = "ActorObject") ActorFormDto actorDto) {
        return actorService.editActor(id,actorDto);
    }

    @WebMethod(operationName = "DeleteActor")
    public boolean deleteActor(@WebParam(name = "actorId") Short id) {
        return actorService.deleteActor(id);
    }
}
