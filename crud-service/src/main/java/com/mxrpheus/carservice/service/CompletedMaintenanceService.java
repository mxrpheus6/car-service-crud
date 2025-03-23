package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.CompletedMaintenanceDTO;

import java.util.List;

public interface CompletedMaintenanceService {
    List<CompletedMaintenanceDTO> getAllCompletedMaintenances();
    CompletedMaintenanceDTO getCompletedMaintenanceById(Long id);
    CompletedMaintenanceDTO createCompletedMaintenance(CompletedMaintenanceDTO clientDTO);
    CompletedMaintenanceDTO updateCompletedMaintenance(Long id, CompletedMaintenanceDTO clientDTO);
    void deleteCompletedMaintenanceById(Long id);
}
