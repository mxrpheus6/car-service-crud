package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.MaintenanceEmployeeDTO;
import com.mxrpheus.carservice.model.MaintenanceEmployee;

import java.util.List;

public interface MaintenanceEmployeeService {
    List<MaintenanceEmployee> getAll();
    MaintenanceEmployee getById(Long serviceId, Long employeeId);
    MaintenanceEmployee create(MaintenanceEmployeeDTO maintenanceEmployeeDTO);
    void deleteById(Long serviceId, Long employeeId);
}
