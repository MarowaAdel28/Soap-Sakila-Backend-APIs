package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.PaymentDto;
import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.dto.RentalFormDto;
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

    @WebMethod(operationName = "RentalById")
    public RentalDto getRental(@WebParam(name = "rentalId") Short id) {
        return rentalService.getById(id);
    }

    @WebMethod(operationName = "AllRentals")
    public List<RentalDto> getAll() {
        return rentalService.getAll();
    }

    public boolean addRental(@WebParam(name = "rental") RentalFormDto rentalFormDto) {
        return rentalService.addRental(rentalFormDto);
    }

    public boolean editRental(@WebParam(name = "rentalId") Integer id, @WebParam(name = "rental") RentalFormDto rentalFormDto) {
        return rentalService.editRental(id,rentalFormDto);
    }

    @WebMethod(operationName = "paymentList")
    public List<PaymentDto> getPaymentList(@WebParam(name = "rentalId") Short id) {
        return rentalService.getPaymentList(id);
    }

    @WebMethod(operationName = "DeleteRental")
    public boolean deleteRental(@WebParam(name = "rentalId") Integer id) {
        return rentalService.deleteRental(id);
    }
}
