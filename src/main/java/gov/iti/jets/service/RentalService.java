package gov.iti.jets.service;

import gov.iti.jets.custommapper.CustomRentalMapper;
import gov.iti.jets.dao.DBFactory;
import gov.iti.jets.dao.RentalDAO;
import gov.iti.jets.dto.RentalDto;
import gov.iti.jets.entity.Rental;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class RentalService {

    private volatile static RentalService rentalService;
    private CustomRentalMapper customRentalMapper;
    private RentalService() {
        customRentalMapper = CustomRentalMapper.getInstance();
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
}
