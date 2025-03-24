package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.CompletedMaintenanceEmployeeDTO;
import com.mxrpheus.carservice.model.CompletedMaintenanceEmployee;

import java.util.List;

public interface CompletedMaintenanceEmployeeService {
    List<CompletedMaintenanceEmployee> getAll();
    CompletedMaintenanceEmployee getById(Long completedServiceId, Long employeeId);
    CompletedMaintenanceEmployee create(CompletedMaintenanceEmployeeDTO completedMaintenanceEmployeeDTO);
    void deleteById(Long completedServiceId, Long employeeId);
}
