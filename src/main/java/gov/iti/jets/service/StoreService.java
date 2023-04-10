package gov.iti.jets.service;

import gov.iti.jets.dao.DBFactory;
import gov.iti.jets.dao.StoreDAO;
import gov.iti.jets.dto.CustomerInfoDto;
import gov.iti.jets.dto.InventoryDto;
import gov.iti.jets.dto.StaffDto;
import gov.iti.jets.dto.StoreDto;
import gov.iti.jets.entity.*;
import gov.iti.jets.mapper.CustomerInfoMapper;
import gov.iti.jets.mapper.InventoryMapper;
import gov.iti.jets.mapper.StaffMapper;
import gov.iti.jets.mapper.StoreMapper;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class StoreService {

    private volatile static StoreService storeService;

    private StoreMapper storeMapper;
    private CustomerInfoMapper customerInfoMapper;

    private StaffMapper staffMapper;

    private InventoryMapper inventoryMapper;

    private StoreService() {

        storeMapper = Mappers.getMapper(StoreMapper.class);
        customerInfoMapper = Mappers.getMapper(CustomerInfoMapper.class);
        storeMapper = Mappers.getMapper(StoreMapper.class);
        inventoryMapper = Mappers.getMapper(InventoryMapper.class);
        staffMapper = Mappers.getMapper(StaffMapper.class);
    }

    public static StoreService getInstance() {
        if(storeService==null) {
            synchronized (StoreService.class) {
                if(storeService==null) {
                    storeService = new StoreService();
                }
            }
        }
        return storeService;
    }

    public StoreDto getStoreById(Short id) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        StoreDAO storeDAO = new StoreDAO(entityManager);
        Store store =storeDAO.get(id);

        StoreDto storeDto = storeMapper.toDto(store);
        storeDto.setStoreAddress(store.getAddressId().getAddress());
        storeDto.setManagerName(store.getManagerStaffId().getFirstName()+" "+store.getManagerStaffId().getLastName());

        dbFactory.closeEntityManager(entityManager);

        return storeDto;
    }

    public List<StoreDto> getAllStores() {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        StoreDAO storeDAO = new StoreDAO(entityManager);
        List<Store> storeList = storeDAO.getAllStores();

        List<StoreDto> storeDtoList = storeMapper.toDTOs(storeList);

        for(int i=0;i<storeList.size();i++) {
            Store store = storeList.get(i);
            storeDtoList.get(i).setStoreAddress(store.getAddressId().getAddress());
            storeDtoList.get(i).setManagerName(store.getManagerStaffId().getFirstName() + " " +
                    store.getManagerStaffId().getLastName());
        }
        dbFactory.closeEntityManager(entityManager);
        return storeDtoList;
    }

    public List<CustomerInfoDto> getStoreCustomerList(Short StoreId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        StoreDAO storeDAO = new StoreDAO(entityManager);
        Store store =storeDAO.get(StoreId);

        List<Customer> customerList = store.getCustomerList();

        List<CustomerInfoDto> customerInfoDtoList = new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerInfoDto customerInfoDto = customerInfoMapper.toDto(customer);
            customerInfoDto.setAddress(customer.getAddressId().getAddress());
            customerInfoDtoList.add(customerInfoDto);
        });

        dbFactory.closeEntityManager(entityManager);

        return customerInfoDtoList;
    }

    public List<StaffDto> getStoreStaffList(Short storeId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        StoreDAO storeDAO = new StoreDAO(entityManager);
        Store store =storeDAO.get(storeId);

        List<Staff> staffList = store.getStaffList();

        List<StaffDto> staffDtoList = staffMapper.toDTOs(staffList);

        dbFactory.closeEntityManager(entityManager);

        return staffDtoList;
    }

    // issue
    public List<InventoryDto> getStoreInventoryList(Short storeId) {
        DBFactory dbFactory = DBFactory.getDbFactoryInstance();
        EntityManager entityManager = dbFactory.createEntityManager();

        StoreDAO storeDAO = new StoreDAO(entityManager);
        Store store =storeDAO.get(storeId);

        List<Inventory> inventoryList = store.getInventoryList();

        List<InventoryDto> inventoryDtos = new ArrayList<>();

        inventoryList.forEach((inventory -> {
            InventoryDto inventoryDto = inventoryMapper.toDto(inventory);
            inventoryDto.setFilmID(inventory.getFilmId().getFilmId());
            inventoryDto.setFilmName(inventory.getFilmId().getTitle());
            inventoryDtos.add(inventoryDto);
        }));

        dbFactory.closeEntityManager(entityManager);

        return inventoryDtos;
    }
}