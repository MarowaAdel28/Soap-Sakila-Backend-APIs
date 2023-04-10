package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.CustomerFormDto;
import gov.iti.jets.dto.CustomerInfoDto;
import gov.iti.jets.dto.PaymentDto;
import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.service.CustomerService;
import jakarta.ws.rs.*;

import java.util.List;

@Path("customers")
public class CustomerResource {

    private CustomerService customerService;

    public CustomerResource() {
        customerService = CustomerService.getCustomerService();
    }

    @GET
    public List<CustomerInfoDto> getAll() {
        return customerService.getAllCustomers();
    }

    @GET
    @Path("{id:[0-9]+}")
    public CustomerInfoDto getById(@PathParam("id") short id) {
        return customerService.getCustomerById(id);
    }

    @GET
    @Path("filter")
    public List<CustomerInfoDto> filterCustomer(@QueryParam("isActivr") boolean isActive) {

        if(isActive) {
            return customerService.getAllActiveCustomers();
        }
        if(!isActive) {
            return customerService.getAllInactiveCustomers();
        }
        return null;
    }

    // count

    @GET
    @Path("{id:[0-9]+}/payment")
    public List<PaymentDto> getCustomerPayment(@PathParam("id") short customerId) {
        return customerService.getCustomerPayment(customerId);
    }

    @GET
    @Path("{id:[0-9]+}/rental")
    public List<RentalDto> getCustomerRental(@PathParam("id") short customerId) {
        return customerService.getCustomerRental(customerId);
    }

    // count

    @GET
    @Path("search")
    public List<CustomerInfoDto> searchByName(@QueryParam("name") String name) {
        return customerService.searchByName(name);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public boolean addCustomer(CustomerFormDto customerFormDto) {
        return customerService.addCustomer(customerFormDto);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Path("{id:[0-9]+}")
    public boolean editCustomer(@PathParam("id") short id, CustomerFormDto customerFormDto) {
        return customerService.editCustomer(id,customerFormDto);
    }
}
