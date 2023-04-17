package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.LanguageDto;
import gov.iti.jets.dto.LanguageFormDto;
import gov.iti.jets.service.LanguageService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class LanguageWebService {

    private LanguageService languageService = LanguageService.getInstance();

//    public LanguageWebService() {
//        languageService = LanguageService.getInstance();
//    }

//    @WebMethod(operationName = "LanguageById")
//    public LanguageDto getById(Short id) {
//        return languageService.getById(id);
//    }


    @WebMethod(operationName = "languageById")
    public LanguageDto getLanguage(@WebParam(name = "languageId") Short id) {
        return languageService.getById(id);
    }
    @WebMethod(operationName = "AllLanguages")
    public List<LanguageDto> getAll() {
        return languageService.getAll();
    }

    public boolean addLanguage(@WebParam(name = "language") LanguageFormDto languageFormDto) {
        return languageService.addLanguage(languageFormDto.getName());
    }

    public boolean editLanguage(@WebParam(name = "languageId") Short languageId, @WebParam(name = "language") LanguageFormDto languageFormDto) {
        return languageService.editLanguage(languageId,languageFormDto.getName());
    }
}
