package gov.iti.jets.service;

import gov.iti.jets.dao.*;
import gov.iti.jets.dto.FilmFormDto;
import gov.iti.jets.entity.*;
import gov.iti.jets.mapper.FilmFormMapper;
import gov.iti.jets.mapper.FilmMapper;
//import gov.iti.jets.views.NicerButSlowerFilmList;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.Date;

public class FilmService {
    private volatile static FilmService filmService;

    private FilmMapper filmMapper;

    private FilmFormMapper filmFormMapper;
    private FilmService() {

        filmMapper = Mappers.getMapper(FilmMapper.class);
        filmFormMapper = Mappers.getMapper(FilmFormMapper.class);
    }
    public static FilmService getFilmServiceInstance() {
        if(filmService==null) {
            synchronized (FilmService.class) {
                if(filmService==null) {
                    filmService = new FilmService();
                }
            }
        }
        return filmService;
    }

    public boolean addFilm(FilmFormDto filmDto) {

        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        FilmDAO filmDAO = new FilmDAO(entityManager);
        LanguageDAO languageDAO = new LanguageDAO(entityManager);

        Film film = filmFormMapper.toEntity(filmDto);
        Language language = languageDAO.get(filmDto.getLanguage());

        film.setLastUpdate(new Date());
        film.setLanguageId(language);

        entityManager.getTransaction().begin();

        boolean result = filmDAO.saveRow(film);

        if(result) {
            // add film category
            boolean result1 = addFilmCategory(entityManager,film,filmDto.getCategory());

            // add film actor
            boolean result2 = addFilmActor(entityManager,film,filmDto.getActor());

            // add inventory
            boolean result3 = addFilmInventory(entityManager,film,filmDto.getStore());

            if(!result1 || !result2 || !result3) {
                result = false;
            } else{
                result = true;
            }
        }
        dbFactory.commitTransaction(entityManager,result);
        dbFactory.closeEntityManager(entityManager);
        return result;
    }
//    public NicerButSlowerFilmList getFilm(short filmId) {
//        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
//        EntityManager entityManager = dbFactory.createEntityManager();
//        NicerFilmListDAO nicerFilmListDAO = new NicerFilmListDAO(entityManager);
//        NicerButSlowerFilmList nicerButSlowerFilmList = nicerFilmListDAO.get(filmId);
//        dbFactory.closeEntityManager(entityManager);
//        return nicerButSlowerFilmList;
//    }

    public FilmText getFilmText(Short filmId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();
        FilmTextDAO filmTextDAO = new FilmTextDAO(entityManager);
        FilmText filmText = filmTextDAO.get(filmId);
        dbFactory.closeEntityManager(entityManager);
        return filmText;
    }

    private boolean addFilmInventory(EntityManager entityManager,Film film, Short storeId) {
        StoreDAO storeDAO = new StoreDAO(entityManager);
        InventoryDAO inventoryDAO = new InventoryDAO(entityManager);

        Store store = storeDAO.get(storeId);
        Inventory inventory = new Inventory();

        inventory.setFilmId(film);
        inventory.setStoreId(store);
        inventory.setLastUpdate(new Date());

        return inventoryDAO.saveRow(inventory);
    }

    private boolean addFilmActor(EntityManager entityManager, Film film, Short actorId) {
        FilmActorDAO filmActorDAO = new FilmActorDAO(entityManager);
        ActorDAO actorDAO = new ActorDAO(entityManager);

        Actor actor = actorDAO.get(actorId);
        FilmActor filmActor = new FilmActor();

        filmActor.setFilm(film);
        filmActor.setActor(actor);
        filmActor.setLastUpdate(new Date());
        FilmActorPK filmActorPK = new FilmActorPK(actor.getActorId(),film.getFilmId());
        filmActor.setFilmActorPK(filmActorPK);

        return filmActorDAO.saveRow(filmActor);
    }

    private boolean addFilmCategory(EntityManager entityManager, Film film, Short categoryId) {

        CategoryDAO categoryDAO = new CategoryDAO(entityManager);
        FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAO(entityManager);

        Category category = categoryDAO.get(categoryId);
        FilmCategory filmCategory = new FilmCategory();
        FilmCategoryPK filmCategoryPK = new FilmCategoryPK(film.getFilmId(),category.getCategoryId());

        filmCategory.setFilmCategoryPK(filmCategoryPK);
        filmCategory.setFilm(film);
        filmCategory.setCategory(category);
        filmCategory.setLastUpdate(new Date());

        return filmCategoryDAO.saveRow(filmCategory);
    }
}
