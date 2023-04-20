package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.FilmDto;
import gov.iti.jets.dto.FilmFormDto;
import gov.iti.jets.entity.FilmText;
import gov.iti.jets.service.FilmService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class FilmWebService {

    FilmService filmService = FilmService.getFilmServiceInstance();

    @WebMethod(operationName = "FilmText")
    public FilmText getFilmText(@WebParam(name = "filmId") short id) {
        return filmService.getFilmText(id);
    }

    @WebMethod(operationName = "AllFilmText")
    public List<FilmText> getAllFilmText() {
        return filmService.getAllFilmText();
    }
    @WebMethod(operationName = "FilmById")
    public FilmDto getFilm(@WebParam(name = "filmId") Short id) {
        return filmService.getById(id);
    }

    @WebMethod(operationName = "AllFilms")
    public List<FilmDto> getAll() {
        return filmService.getAll();
    }
    public boolean addFilm(@WebParam(name = "film") FilmFormDto filmFormDto) {
        return filmService.addFilm(filmFormDto);
    }

    @WebMethod(operationName = "DeleteFilm")
    public boolean deleteFilm(@WebParam(name = "filmId") Short id) {
        return filmService.deleteFilm(id);
    }
}
