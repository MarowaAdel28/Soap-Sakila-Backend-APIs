package gov.iti.jets.service;

import gov.iti.jets.custommapper.CustomPaymentMapper;
import gov.iti.jets.custommapper.CustomRentalMapper;
import gov.iti.jets.dao.*;
import gov.iti.jets.dto.PaymentDto;
import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.dto.RentalFormDto;
import gov.iti.jets.entity.*;
import jakarta.persistence.EntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RentalService {

    private volatile static RentalService rentalService;
    private CustomRentalMapper customRentalMapper;

    private CustomPaymentMapper customPaymentMapper;
    private RentalService() {
        customRentalMapper = CustomRentalMapper.getInstance();
        customPaymentMapper = CustomPaymentMapper.getInstance();
    }

    public static RentalService getInstance() {
        if (rentalService == null) {
            synchronized (RentalService.class) {
                if (rentalService == null) {
                    rentalService = new RentalService();
                }
            }
        }
        return rentalService;
    }

    public RentalDto getById(Short id) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        RentalDAO rentalDAO = new RentalDAO(entityManager);

        Rental rental = rentalDAO.get(id);
        RentalDto rentalDto = customRentalMapper.toRentalDto(rental);

        dbFactory.closeEntityManager(entityManager);
        return rentalDto;
    }

    public List<RentalDto> getAll() {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        RentalDAO rentalDAO = new RentalDAO(entityManager);

        List<Rental> rentalList = rentalDAO.getAll();
        List<RentalDto> rentalDtoList = new ArrayList<>();

        rentalList.forEach((rental -> rentalDtoList.add(customRentalMapper.toRentalDto(rental))));

        dbFactory.closeEntityManager(entityManager);
        return rentalDtoList;
    }

    public List<PaymentDto> getPaymentList(Short rentalId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        RentalDAO rentalDAO = new RentalDAO(entityManager);

        Rental rental = rentalDAO.get(rentalId);
        List<Payment> paymentList = rental.getPaymentList();
        List<PaymentDto> paymentDtoList = new ArrayList<>();

        paymentList.forEach((payment -> paymentDtoList.add(customPaymentMapper.toPaymentDto(payment))));
        dbFactory.closeEntityManager(entityManager);

        return paymentDtoList;
    }

    public boolean addRental(RentalFormDto rentalFormDto) {
        boolean result = false;
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        RentalDAO rentalDAO = new RentalDAO(entityManager);
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        InventoryDAO inventoryDAO = new InventoryDAO(entityManager);
        StaffDAO staffDAO = new StaffDAO(entityManager);
        PaymentDAO paymentDAO = new PaymentDAO(entityManager);

        Customer customer = customerDAO.get(rentalFormDto.getCustomer());
        Inventory inventory = inventoryDAO.get(rentalFormDto.getInventory());
        Staff staff = staffDAO.get(rentalFormDto.getStaff());

        Rental rental = new Rental();

        rental.setRentalDate(craeteDate(rentalFormDto.getRentalDt()));
        rental.setReturnDate(craeteDate(rentalFormDto.getReturnDt()));
        rental.setLastUpdate(new Date());
        rental.setStaffId(staff);
        rental.setCustomerId(customer);
        rental.setInventoryId(inventory);

        entityManager.getTransaction().begin();

        result = rentalDAO.saveRow(rental);

        if(result) {
            // add payment
            Payment payment = new Payment();

            payment.setRentalId(rental);
            payment.setPaymentDate(new Date());
            payment.setCustomerId(customer);
            payment.setAmount(rentalFormDto.getAmount());
            payment.setLastUpdate(new Date());
            payment.setStaffId(staff);

            result = paymentDAO.saveRow(payment);
        }

        if(result) {
            System.out.println("every thing is oky");
            entityManager.getTransaction().commit();
        } else {
            System.out.println("some thing wrong");
            entityManager.getTransaction().rollback();
        }

        dbFactory.closeEntityManager(entityManager);
        return result;
    }

    public boolean editRental(Short rentalId, RentalFormDto rentalFormDto) {
        boolean result = false;
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        RentalDAO rentalDAO = new RentalDAO(entityManager);
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        InventoryDAO inventoryDAO = new InventoryDAO(entityManager);
        StaffDAO staffDAO = new StaffDAO(entityManager);
        PaymentDAO paymentDAO = new PaymentDAO(entityManager);

        Customer customer = customerDAO.get(rentalFormDto.getCustomer());
        Inventory inventory = inventoryDAO.get(rentalFormDto.getInventory());
        Staff staff = staffDAO.get(rentalFormDto.getStaff());

        Rental rental = rentalDAO.get(rentalId);

        if(rental == null) {
            return false;
        }

        rental.setRentalDate(craeteDate(rentalFormDto.getRentalDt()));
        rental.setLastUpdate(new Date());
        rental.setStaffId(staff);
        rental.setCustomerId(customer);
        rental.setReturnDate(craeteDate(rentalFormDto.getReturnDt()));
        rental.setInventoryId(inventory);

        System.out.println("----------------------");
        System.out.println(rentalFormDto.getRentalDt());
        System.out.println("---------------------------------");

        entityManager.getTransaction().begin();

        result = rentalDAO.saveRow(rental);

        if(result) {
            // add payment
            Payment payment = new Payment();

            payment.setRentalId(rental);
            payment.setPaymentDate(new Date());
            payment.setCustomerId(customer);
            payment.setAmount(rentalFormDto.getAmount());
            payment.setLastUpdate(new Date());
            payment.setStaffId(staff);

            result = paymentDAO.saveRow(payment);
        }

        if(result) {
            System.out.println("every thing is oky");
            entityManager.getTransaction().commit();
        } else {
            System.out.println("some thing wrong");
            entityManager.getTransaction().rollback();
        }

        dbFactory.closeEntityManager(entityManager);
        return result;
    }

    private Date craeteDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm dd yyyy HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
