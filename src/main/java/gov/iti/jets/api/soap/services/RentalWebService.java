package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.service.RentalService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class RentalWebService {

    private RentalService rentalService;
    public RentalWebService() {
        rentalService = RentalService.getInstance();
    }
//    @WebMethod(operationName = "RentalById")
//    public RentalDto getById(@WebParam(name = "rentalId") Short id) {
//        return rentalService.getById(id);
//    }

    @WebMethod(operationName = "AllRentals")
    public List<RentalDto> getAll() {
        return rentalService.getAll();
    }
}
