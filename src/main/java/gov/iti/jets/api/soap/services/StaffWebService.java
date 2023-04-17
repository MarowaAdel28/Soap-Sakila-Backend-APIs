package gov.iti.jets.api.soap.services;

import gov.iti.jets.dto.StaffDto;
import gov.iti.jets.dto.StaffFormDto;
import gov.iti.jets.service.StaffService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class StaffWebService {

    private StaffService service;

    public StaffWebService() {
        service = StaffService.getInstance();
    }

//    @WebMethod(operationName = "StaffById")
//    public StaffDto getById(@WebParam(name = "staffId") short id) {
//        return service.getById(id);
//    }

    @WebMethod(operationName = "AllStaffs")
    public List<StaffDto> getAll() {
        return service.getAll();
    }

    @WebMethod(operationName = "StaffById")
    public StaffDto getStaff(@WebParam(name = "staffId") Short id) {
        return service.getById(id);
    }
    public boolean addStaff(@WebParam(name = "staff") StaffFormDto staffFormDto) {
        return service.addStaff(staffFormDto);
    }

    public boolean editStaff(@WebParam(name = "staffId") Short staffId, @WebParam(name = "staff") StaffFormDto staffFormDto) {
        return service.editStaff(staffId,staffFormDto);
    }
}
