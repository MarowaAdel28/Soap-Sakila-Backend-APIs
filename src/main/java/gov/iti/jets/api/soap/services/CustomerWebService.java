package gov.iti.jets.api.soap.services;

import gov.iti.jets.dao.CustomerDAO;
import gov.iti.jets.dto.CustomerDto;
import gov.iti.jets.dto.CustomerInfoDto;
import gov.iti.jets.dto.PaymentDto;
import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.entity.Customer;
import gov.iti.jets.entity.Payment;
import gov.iti.jets.entity.Rental;
import gov.iti.jets.service.CustomerService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.math.BigDecimal;
import java.util.List;

@WebService
public class CustomerWebService {

    private CustomerService customerService = CustomerService.getCustomerService();

    @WebMethod(operationName = "CustomerById")
    public CustomerInfoDto getCustomerById(@WebParam(name = "customerId") short customerId) {

        return customerService.getCustomerById(customerId);
    }

    @WebMethod(operationName = "AllCustomerList")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @WebMethod(operationName = "AllActiveCustomerList")
    public List<CustomerDto> getAllActiveCustomers() {
        return customerService.getAllActiveCustomers();
    }

    @WebMethod(operationName = "AllInActiveCustomerList")
    public List<CustomerDto> getAllInactiveCustomers() {
        return customerService.getAllInactiveCustomers();
    }

    @WebMethod(operationName = "AllStoreCustomerList")
    public List<CustomerDto> getAllStoreCustomers(@WebParam(name = "storeId") Short storeId) {
        return customerService.getAllStoreCustomers(storeId);
    }

    @WebMethod(operationName = "AllCustomerCount")
    public int getAllCustomersCount() {
        return customerService.getAllCustomersCount();
    }

    @WebMethod(operationName = "AllActiveCustomerCount")
    public int getAllActiveCustomersCount() {
        return customerService.getAllActiveCustomersCount();
    }

    @WebMethod(operationName = "AllInActiveCustomerCount")
    public int getAllInactiveCustomersCount() {
        return customerService.getAllInactiveCustomersCount();
    }

    @WebMethod(operationName = "AllStoreCustomerCount")
    public int getAllStoreCustomersCount(@WebParam(name = "storeId") short storeId) {
        return customerService.getAllStoreCustomersCount(storeId);
    }
    @WebMethod(operationName = "CustomerPaymentList")
    public List<PaymentDto> getCustomerPayment(@WebParam(name = "customerId") short customerId) {
        return customerService.getCustomerPayment(customerId);
    }

    @WebMethod(operationName = "CustomerTotalPaymentAmount")
    public BigDecimal getTotalAmount(@WebParam(name = "customerId") short customerId) {
        return customerService.getTotalAmount(customerId);
    }

    @WebMethod(operationName = "CustomerRentalList")
    public List<RentalDto> getCustomerRental(@WebParam(name = "customerId") short customerId) {
        return customerService.getCustomerRental(customerId);
    }

    @WebMethod(operationName = "CustomerRentalCount")
    public int getCustomerRentalCount(@WebParam(name = "customerId") short customerId) {
        return customerService.getCustomerRentalCount(customerId);
    }

    @WebMethod(operationName = "SearchCustomerByName")
    public List<CustomerInfoDto> searchByName(@WebParam(name = "customerName") String name) {
        return customerService.searchByName(name);
    }
}
