package gov.iti.jets.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBFactory {

    private static DBFactory dbFactoryInstance = new DBFactory();
    private EntityManagerFactory entityManagerFactory;

    public static DBFactory getDbFactoryInstance() {
        return dbFactoryInstance;
    }

    private DBFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Sakila");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    // private final static EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Sakila");

    // private DBFactory() {

    // }

    // public static EntityManagerFactory getInstance() {
    //     return entityManagerFactory;
    // }
}
