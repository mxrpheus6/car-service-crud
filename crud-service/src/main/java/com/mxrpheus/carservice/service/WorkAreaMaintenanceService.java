package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.WorkAreaMaintenanceDTO;
import com.mxrpheus.carservice.model.WorkAreaMaintenance;

import java.util.List;

public interface WorkAreaMaintenanceService {
    List<WorkAreaMaintenance> getAll();
    WorkAreaMaintenance getById(Long workAreaId, Long serviceId);
    WorkAreaMaintenance create(WorkAreaMaintenanceDTO workAreaMaintenanceDTO);
    //WorkAreaMaintenance update(Long workAreaId, Long serviceId, WorkAreaMaintenanceDTO workAreaMaintenanceDTO);
    void deleteById(Long workAreaId, Long serviceId);
}
