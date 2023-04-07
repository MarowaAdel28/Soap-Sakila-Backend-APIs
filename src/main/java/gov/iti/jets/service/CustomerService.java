package gov.iti.jets.service;

import gov.iti.jets.dao.CustomerDAO;
import gov.iti.jets.dto.CustomerDto;
import gov.iti.jets.dto.CustomerInfoDto;
import gov.iti.jets.dto.PaymentDto;
import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.entity.Customer;
import gov.iti.jets.entity.Payment;
import gov.iti.jets.entity.Rental;
import gov.iti.jets.mapper.CustomerInfoMapper;
import gov.iti.jets.mapper.CustomerMapper;
import gov.iti.jets.mapper.PaymentMapper;
import gov.iti.jets.mapper.RentalMapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private volatile static CustomerService customerService;
    private CustomerMapper customerMapper;

    private PaymentMapper paymentMapper;

    private RentalMapper rentalMapper;

    private CustomerInfoMapper customerInfoMapper;

    private CustomerService() {
        customerMapper = Mappers.getMapper(CustomerMapper.class);
        paymentMapper = Mappers.getMapper(PaymentMapper.class);
        rentalMapper = Mappers.getMapper(RentalMapper.class);
        customerInfoMapper = Mappers.getMapper(CustomerInfoMapper.class);
    }

    public static CustomerService getCustomerService() {
        if(customerService==null) {
            synchronized (CustomerService.class) {
                if(customerService==null) {
                    customerService = new CustomerService();
                }
            }
        }
        return customerService;
    }

    public CustomerInfoDto getCustomerById(short customerId) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.get(customerId);
        CustomerInfoDto customerInfoDto = customerInfoMapper.toDto(customer);
        customerInfoDto.setAddress(customer.getAddressId().getAddress());
        //return customerMapper.toDto(customer);
        return customerInfoDto;
    }

    public List<CustomerDto> getAllCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = customerDAO.getAllCustomers();
        return customerMapper.toDTOs(customerList);
    }

    public List<CustomerDto> getAllActiveCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = customerDAO.getAllActiveCustomers();
        return customerMapper.toDTOs(customerList);
    }

    public List<CustomerDto> getAllInactiveCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = customerDAO.getAllInactiveCustomers();
        return customerMapper.toDTOs(customerList);
    }

    public List<CustomerDto> getAllStoreCustomers(Short storeId) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = customerDAO.getAllCustomersInStore(storeId);
        return customerMapper.toDTOs(customerList);
    }

    public int getAllCustomersCount() {
        return getAllCustomers().size();
    }

    public int getAllActiveCustomersCount() {
        return getAllActiveCustomers().size();
    }

    public int getAllInactiveCustomersCount() {
        return getAllInactiveCustomers().size();
    }

    public int getAllStoreCustomersCount(short storeId) {
        return getAllStoreCustomers(storeId).size();
    }

    public List<PaymentDto> getCustomerPayment(short customerId) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Payment> paymentList = customerDAO.get(customerId).getPaymentList();
        return paymentMapper.toDTOs(paymentList);
    }

    public BigDecimal getTotalAmount(short customerId) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Payment> paymentList = customerDAO.get(customerId).getPaymentList();
        BigDecimal totalAmount = paymentList.stream().map(Payment::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalAmount;
    }

    public List<RentalDto> getCustomerRental(short customerId) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Rental> rentalList = customerDAO.get(customerId).getRentalList();
        return rentalMapper.toDTOs(rentalList);
    }
    public int getCustomerRentalCount(short customerId) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Rental> rentalList = customerDAO.get(customerId).getRentalList();
        return rentalList.size();
    }

    public List<CustomerInfoDto> searchByName(String name) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = customerDAO.searchCustomerByName(name);
        List<CustomerInfoDto> customerInfoDtoList = new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerInfoDto customerInfoDto = customerInfoMapper.toDto(customer);
            customerInfoDto.setAddress(customer.getAddressId().getAddress());
            customerInfoDtoList.add(customerInfoDto);
        });
        return customerInfoDtoList;
    }

}
