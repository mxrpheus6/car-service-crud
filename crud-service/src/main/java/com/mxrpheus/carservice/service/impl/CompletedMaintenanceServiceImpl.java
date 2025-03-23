package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.CompletedMaintenanceDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.CompletedMaintenanceMapper;
import com.mxrpheus.carservice.model.CompletedMaintenance;
import com.mxrpheus.carservice.model.Maintenance;
import com.mxrpheus.carservice.model.WorkArea;
import com.mxrpheus.carservice.model.WorkOrder;
import com.mxrpheus.carservice.repository.CompletedMaintenanceRepository;
import com.mxrpheus.carservice.repository.MaintenanceRepository;
import com.mxrpheus.carservice.repository.WorkAreaRepository;
import com.mxrpheus.carservice.repository.WorkOrderRepository;
import com.mxrpheus.carservice.service.CompletedMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompletedMaintenanceServiceImpl implements CompletedMaintenanceService {

    private final CompletedMaintenanceRepository completedMaintenanceRepository;
    private final WorkOrderRepository workOrderRepository;
    private final WorkAreaRepository workAreaRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final CompletedMaintenanceMapper completedMaintenanceMapper;

    @Override
    public List<CompletedMaintenanceDTO> getAllCompletedMaintenances() {
        return completedMaintenanceMapper.toDtoList(completedMaintenanceRepository.findAll());
    }

    @Override
    public CompletedMaintenanceDTO getCompletedMaintenanceById(Long id) {
        return completedMaintenanceMapper.toDto(completedMaintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Completed service with id=" + id + " not found")));
    }

    @Override
    public CompletedMaintenanceDTO createCompletedMaintenance(CompletedMaintenanceDTO completedMaintenanceDTO) {
        WorkOrder workOrder = workOrderRepository.findById(completedMaintenanceDTO.getWorkOrderId())
                .orElseThrow(() -> new NoSuchEntityException("Work order with id=" + completedMaintenanceDTO.getWorkOrderId() + " not found"));

        WorkArea workArea = workAreaRepository.findById(completedMaintenanceDTO.getWorkAreaId())
                .orElseThrow(() -> new NoSuchEntityException("Work area with id=" + completedMaintenanceDTO.getWorkAreaId() + " not found"));

        Maintenance maintenance = maintenanceRepository.findById(completedMaintenanceDTO.getServiceId())
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + completedMaintenanceDTO.getServiceId() + " not found"));


        completedMaintenanceDTO.setId(null);
        CompletedMaintenance completedMaintenance = completedMaintenanceMapper.toEntity(completedMaintenanceDTO);
        completedMaintenance.setWorkOrder(workOrder);
        completedMaintenance.setWorkArea(workArea);
        completedMaintenance.setService(maintenance);

        return completedMaintenanceMapper.toDto(completedMaintenanceRepository.save(completedMaintenance));
    }

    @Override
    public CompletedMaintenanceDTO updateCompletedMaintenance(Long id, CompletedMaintenanceDTO completedMaintenanceDTO) {
        CompletedMaintenance completedMaintenance = completedMaintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Completed service with id=" + id + " not found"));

        completedMaintenanceDTO.setId(null);
        completedMaintenanceMapper.updateCompletedMaintenance(completedMaintenanceDTO, completedMaintenance);

        if (completedMaintenanceDTO.getWorkOrderId() != null) {
            WorkOrder workOrder = workOrderRepository.findById(completedMaintenanceDTO.getWorkOrderId())
                    .orElseThrow(() -> new NoSuchEntityException("Work order with id=" + completedMaintenanceDTO.getWorkOrderId() + " not found"));

            completedMaintenance.setWorkOrder(workOrder);
        }
        if (completedMaintenanceDTO.getWorkAreaId() != null) {
            WorkArea workArea = workAreaRepository.findById(completedMaintenanceDTO.getWorkAreaId())
                    .orElseThrow(() -> new NoSuchEntityException("Work area with id=" + completedMaintenanceDTO.getWorkAreaId() + " not found"));

            completedMaintenance.setWorkArea(workArea);
        }
        if (completedMaintenanceDTO.getServiceId() != null) {
            Maintenance maintenance = maintenanceRepository.findById(completedMaintenanceDTO.getServiceId())
                    .orElseThrow(() -> new NoSuchEntityException("Service with id=" + completedMaintenanceDTO.getServiceId() + " not found"));

            completedMaintenance.setService(maintenance);
        }

        return completedMaintenanceMapper.toDto(completedMaintenanceRepository.save(completedMaintenance));
    }

    @Override
    public void deleteCompletedMaintenanceById(Long id) {
        CompletedMaintenance completedMaintenance = completedMaintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Completed service with id=" + id + " not found"));

        completedMaintenanceRepository.delete(completedMaintenance);
    }
}
