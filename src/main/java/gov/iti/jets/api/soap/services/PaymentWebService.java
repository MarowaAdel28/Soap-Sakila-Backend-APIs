package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.*;
import gov.iti.jets.service.PaymentService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class PaymentWebService {

    private PaymentService paymentService = PaymentService.getInstance();

//    public PaymentWebService() {
//        paymentService  = PaymentService.getInstance();
//    }

//    @WebMethod(operationName = "PaymentById")
//    public PaymentDto getById(@WebParam(name = "paymentId") Short id) {
//        return paymentService.getById(id);
//    }

    @WebMethod(operationName = "AllPayments")
    public List<PaymentDto> getAll() {
//        PaymentDto paymentDto = paymentService.getAll().get(0);
//        System.out.println(paymentDto);
        return paymentService.getAll();
    }

    @WebMethod(operationName = "count")
    public int count() {
        return paymentService.getAll().size();

    }
}
