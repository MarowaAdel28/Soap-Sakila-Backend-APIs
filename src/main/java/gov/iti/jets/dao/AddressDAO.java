package gov.iti.jets.dao;

import gov.iti.jets.entity.Address;
import jakarta.persistence.EntityManager;

public class AddressDAO extends BaseDAO<Address> {

    public AddressDAO(EntityManager entityManager) {
        super(Address.class,entityManager);
    }
}
