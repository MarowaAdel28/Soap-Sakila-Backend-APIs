package gov.iti.jets.service;

import gov.iti.jets.custommapper.CustomPaymentMapper;
import gov.iti.jets.custommapper.CustomRentalMapper;
import gov.iti.jets.dao.*;
import gov.iti.jets.dto.*;
import gov.iti.jets.entity.*;
import gov.iti.jets.mapper.*;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerService {

    private volatile static CustomerService customerService;
//    private CustomerMapper customerMapper;

//    private PaymentMapper paymentMapper;

    private CustomPaymentMapper customPaymentMapper;

    private CustomRentalMapper customRentalMapper;

//    private RentalMapper rentalMapper;

    private CustomerInfoMapper customerInfoMapper;

    private CustomerFormMapper customerFormMapper;

    private CustomerService() {
//        customerMapper = Mappers.getMapper(CustomerMapper.class);
//        paymentMapper = Mappers.getMapper(PaymentMapper.class);
        customPaymentMapper = CustomPaymentMapper.getInstance();
        customRentalMapper = CustomRentalMapper.getInstance();
//        rentalMapper = Mappers.getMapper(RentalMapper.class);
        customerInfoMapper = Mappers.getMapper(CustomerInfoMapper.class);
        customerFormMapper = Mappers.getMapper(CustomerFormMapper.class);
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
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        CustomerDAO customerDAO = new CustomerDAO(entityManager);

        Customer customer = customerDAO.get(customerId);

        CustomerInfoDto customerInfoDto = customerInfoMapper.toDto(customer);

        customerInfoDto.setAddress(customer.getAddressId().getAddress());

        dbFactory.closeEntityManager(entityManager);

        return customerInfoDto;
    }

    public List<CustomerInfoDto> getAllCustomers() {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        List<Customer> customerList = customerDAO.getAllCustomers();

        List<CustomerInfoDto> customerInfoDtoList = toDtos(customerList);

        dbFactory.closeEntityManager(entityManager);
        return customerInfoDtoList;
    }

    public List<CustomerInfoDto> getAllActiveCustomers() {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        List<Customer> customerList = customerDAO.getAllActiveCustomers();
        List<CustomerInfoDto> customerInfoDtoList = toDtos(customerList);

        dbFactory.closeEntityManager(entityManager);
        return customerInfoDtoList;
    }

    public List<CustomerInfoDto> getAllInactiveCustomers() {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        List<Customer> customerList = customerDAO.getAllInactiveCustomers();
        List<CustomerInfoDto> customerInfoDtoList = toDtos(customerList);
        dbFactory.closeEntityManager(entityManager);
        return customerInfoDtoList;
    }

//    public List<CustomerDto> getAllStoreCustomers(Short storeId) {
//        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
//        EntityManager entityManager = dbFactory.createEntityManager();
//        CustomerDAO customerDAO = new CustomerDAO(entityManager);
//        List<Customer> customerList = customerDAO.getAllCustomersInStore(storeId);
//        dbFactory.closeEntityManager(entityManager);
//        return customerMapper.toDTOs(customerList);
//    }

    public int getAllCustomersCount() {
        return getAllCustomers().size();
    }

    public int getAllActiveCustomersCount() {
        return getAllActiveCustomers().size();
    }

    public int getAllInactiveCustomersCount() {
        return getAllInactiveCustomers().size();
    }

//    public int getAllStoreCustomersCount(short storeId) {
//        return getAllStoreCustomers(storeId).size();
//    }

    public List<PaymentDto> getCustomerPayment(short customerId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        List<Payment> paymentList = customerDAO.get(customerId).getPaymentList();
        List<PaymentDto> paymentDtoList = new ArrayList<>();
        paymentList.forEach(payment -> {
            paymentDtoList.add(customPaymentMapper.toPaymentDto(payment));
        });
        dbFactory.closeEntityManager(entityManager);
        return paymentDtoList;
    }

    public BigDecimal getTotalAmount(short customerId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        List<Payment> paymentList = customerDAO.get(customerId).getPaymentList();

        BigDecimal totalAmount = paymentList.stream().map(Payment::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        dbFactory.closeEntityManager(entityManager);

        return totalAmount;
    }

    public List<RentalDto> getCustomerRental(short customerId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        List<Rental> rentalList = customerDAO.get(customerId).getRentalList();
        List<RentalDto> rentalDtoList = new ArrayList<>();

        for (Rental rental : rentalList) {
            rentalDtoList.add(customRentalMapper.toRentalDto(rental));
        }

        dbFactory.closeEntityManager(entityManager);

        return rentalDtoList;
    }
    public int getCustomerRentalCount(short customerId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);

        List<Rental> rentalList = customerDAO.get(customerId).getRentalList();

        int count = rentalList.size();

        dbFactory.closeEntityManager(entityManager);

        return count;
    }

    public List<CustomerInfoDto> searchByName(String name) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        List<Customer> customerList = customerDAO.searchCustomerByName(name);

        List<CustomerInfoDto> customerInfoDtoList = toDtos(customerList);

        dbFactory.closeEntityManager(entityManager);

        return customerInfoDtoList;
    }

    public boolean addCustomer(CustomerFormDto customerDto) {

        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        CityDAO cityDAO = new CityDAO(entityManager);
        CountryDAO countryDAO = new CountryDAO(entityManager);
        AddressDAO addressDAO = new AddressDAO(entityManager);
        StoreDAO storeDAO = new StoreDAO(entityManager);

        City city = cityDAO.get(customerDto.getCity());

        Country country = countryDAO.get(customerDto.getCountry());

        Store store = storeDAO.get(customerDto.getStore());

        if(store==null || country ==null || city==null) {
//            System.out.println("store is null");
            return false;
        }
//        Address address = saveOrUpdateAddress(false,customerDto,city,null,addressDAO);
        Address address = customerFormMapper.toAddressEntity(customerDto);
        address.setCityId(city);
        address.setLastUpdate(new Date());

        if(!addressDAO.save(address)) {
            System.out.println("can't save address is null");
            return false;
        }

        Customer customer = customerFormMapper.toEntity(customerDto);

//        customer.setLastUpdate(new Date());
        customer.setAddressId(address);
        customer.setStoreId(store);
        boolean isSaved = customerDAO.save(customer);

        dbFactory.closeEntityManager(entityManager);

//        System.out.println(customer.getCreateDate());

        return isSaved;

    }

    public boolean editCustomer(Short id, CustomerFormDto customerDto) {

        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        CityDAO cityDAO = new CityDAO(entityManager);
        CountryDAO countryDAO = new CountryDAO(entityManager);
        AddressDAO addressDAO = new AddressDAO(entityManager);
        StoreDAO storeDAO = new StoreDAO(entityManager);

        City city = cityDAO.get(customerDto.getCity());

        Country country = countryDAO.get(customerDto.getCountry());

        Store store = storeDAO.get(customerDto.getStore());

        Short originalAddressId = customerDAO.get(id).getAddressId().getAddressId();

        Date customerCreateDate = customerDAO.get(id).getCreateDate();

        if(store==null || country ==null || city==null) {
//            System.out.println("store is null");
            return false;
        }

//        Address address = saveOrUpdateAddress(false,customerDto,city,originalAddressId,addressDAO);

        Address address = customerFormMapper.toAddressEntity(customerDto);
        address.setCityId(city);
        address.setLastUpdate(new Date());

        address.setAddressId(originalAddressId);

        if (!addressDAO.update(address)) {
            System.out.println("can't update address is null");
            return false;
        }

        Customer customer = customerFormMapper.toEntity(customerDto);

        customer.setLastUpdate(new Date());
        customer.setAddressId(address);
        customer.setStoreId(store);
        customer.setCustomerId(id);
        customer.setCreateDate(customerCreateDate);

        boolean isSaved = customerDAO.update(customer);

        dbFactory.closeEntityManager(entityManager);

        return isSaved;

    }

    private List<CustomerInfoDto> toDtos(List<Customer> customerList) {
        List<CustomerInfoDto> customerInfoDtoList = new ArrayList<>();

        for(int i=0; i<customerList.size();i++) {
            Customer customer = customerList.get(i);
            CustomerInfoDto customerInfoDto = customerInfoMapper.toDto(customer);

            customerInfoDto.setAddress(customer.getAddressId().getAddress());

            customerInfoDtoList.add(customerInfoDto);
        }
        return customerInfoDtoList;
    }

//    private Address saveOrUpdateAddress(boolean isSave, CustomerFormDto customerDto,City city,Short addressId, AddressDAO addressDAO) {
//        Address address = customerFormMapper.toAddressEntity(customerDto);
//        address.setCityId(city);
//        address.setLastUpdate(new Date());
//
//        if(!isSave) {
//            address.setAddressId(addressId);
//
//            if (!addressDAO.update(address)) {
//                System.out.println("can't update address is null");
//                return null;
//            }
//        } else if (isSave) {
//            if(!addressDAO.save(address)) {
//                System.out.println("can't save address is null");
//                return null;
//            }
//        }
//        return address;
//    }
}
