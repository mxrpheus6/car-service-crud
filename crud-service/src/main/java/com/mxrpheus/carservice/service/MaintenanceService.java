package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.MaintenanceDTO;

import java.util.List;

public interface MaintenanceService {
    List<MaintenanceDTO> getAllServices();
    MaintenanceDTO getServiceById(Long id);
    MaintenanceDTO createService(MaintenanceDTO maintenanceDTO);
    MaintenanceDTO updateService(Long id, MaintenanceDTO maintenanceDTO);
    void deleteServiceById(Long id);
}
