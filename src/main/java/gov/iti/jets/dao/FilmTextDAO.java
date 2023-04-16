package gov.iti.jets.dao;

import gov.iti.jets.entity.FilmText;
import jakarta.persistence.EntityManager;

public class FilmTextDAO extends BaseDAO<FilmText> {

    public FilmTextDAO(EntityManager entityManager) {
        super(FilmText.class, entityManager);
    }
}
