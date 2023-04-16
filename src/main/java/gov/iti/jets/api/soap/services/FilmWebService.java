package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.FilmFormDto;
import gov.iti.jets.service.FilmService;
import gov.iti.jets.views.NicerButSlowerFilmList;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class FilmWebService {

    FilmService filmService = FilmService.getFilmServiceInstance();

    @WebMethod(operationName = "FilmInfoById")
    public NicerButSlowerFilmList getFilmInfoById(@WebParam(name = "filmId") short id) {
        return filmService.getFilm(id);
    }

    public boolean addFilm(@WebParam(name = "film") FilmFormDto filmFormDto) {
        return filmService.addFilm(filmFormDto);
    }
}
