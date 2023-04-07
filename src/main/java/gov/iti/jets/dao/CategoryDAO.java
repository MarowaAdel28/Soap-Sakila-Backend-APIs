package gov.iti.jets.dao;

import gov.iti.jets.entity.Actor;
import gov.iti.jets.entity.Category;
import jakarta.persistence.Query;

import java.util.List;

public class CategoryDAO extends BaseDAO<Category>{

    public CategoryDAO() {
        super(Category.class);
    }

    public List<Category> getAllCategories() {
        String queryString = "from Category c ";
        Query q = entityManager.createQuery(queryString);
        return (List<Category>) q.getResultList();
    }

    public List<Category> searchByCategoryName(String name) {
        String queryString = "from Category c where c.name like :name";
        Query q = entityManager.createQuery(queryString)
                .setParameter("name", name);
        return (List<Category>) q.getResultList();
    }
}
