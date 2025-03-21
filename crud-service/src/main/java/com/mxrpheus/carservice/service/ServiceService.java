package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.ServiceDTO;

import java.util.List;

/**
 * Yeah, I know, "ServiceService" sounds weird.
 * But in this project I follow the naming convention where services are named [Entity]Service.
 * So, for consistency across the codebase, this is what we've got:
 * Сar → CarService;
 * Employee → EmployeeService;
 * Service → ServiceService;
 * It's not perfect, but it keeps things simple and predictable.
 */
public interface ServiceService {
    List<ServiceDTO> getAllServices();
    ServiceDTO getServiceById(Long id);
    ServiceDTO createService(ServiceDTO serviceDTO);
    ServiceDTO updateService(Long id, ServiceDTO serviceDTO);
    void deleteServiceById(Long id);
}
