package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.WorkAreaMaintenanceDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.model.Maintenance;
import com.mxrpheus.carservice.model.WorkArea;
import com.mxrpheus.carservice.model.WorkAreaMaintenance;
import com.mxrpheus.carservice.model.id.WorkAreaMaintenanceId;
import com.mxrpheus.carservice.repository.MaintenanceRepository;
import com.mxrpheus.carservice.repository.WorkAreaMaintenanceRepository;
import com.mxrpheus.carservice.repository.WorkAreaRepository;
import com.mxrpheus.carservice.service.WorkAreaMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkAreaMaintenanceServiceImpl implements WorkAreaMaintenanceService {

    private final WorkAreaMaintenanceRepository workAreaMaintenanceRepository;
    private final WorkAreaRepository workAreaRepository;
    private final MaintenanceRepository maintenanceRepository;

    @Override
    public List<WorkAreaMaintenance> getAll() {
        return workAreaMaintenanceRepository.findAll();
    }

    @Override
    public WorkAreaMaintenance getById(Long workAreaId, Long serviceId) {
        WorkAreaMaintenanceId id = new WorkAreaMaintenanceId();
        id.setWorkAreaId(workAreaId);
        id.setServiceId(serviceId);

        return workAreaMaintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with work area id=" + workAreaId +
                        " and service id=" + serviceId + " not found"));
    }

    @Override
    public WorkAreaMaintenance create(WorkAreaMaintenanceDTO workAreaMaintenanceDTO) {
        Long workAreaId = workAreaMaintenanceDTO.getWorkAreaId();
        Long serviceId = workAreaMaintenanceDTO.getServiceId();

        WorkArea workArea = workAreaRepository.findById(workAreaId)
                .orElseThrow(() -> new NoSuchEntityException("Work area with id=" + workAreaId + " not found"));

        Maintenance service = maintenanceRepository
                .findById(serviceId)
                .orElseThrow(() -> new NoSuchEntityException(
                        "Service with id=" + serviceId + " not found"));

        WorkAreaMaintenance workAreaMaintenance = new WorkAreaMaintenance();
        workAreaMaintenance.setService(service);
        workAreaMaintenance.setWorkArea(workArea);;

        return workAreaMaintenanceRepository.save(workAreaMaintenance);
    }

    /*@Override
    public WorkAreaMaintenance update(Long workAreaId, Long serviceId, WorkAreaMaintenanceDTO workAreaMaintenanceDTO) {
        WorkAreaMaintenanceId id = new WorkAreaMaintenanceId();
        id.setWorkAreaId(workAreaId);
        id.setServiceId(serviceId);

        WorkAreaMaintenance existingRecord = workAreaMaintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with work area id=" + workAreaId +
                        " and service id=" + serviceId + " not found"));

        Long newWorkAreaId = workAreaMaintenanceDTO.getWorkAreaId();
        Long newServiceId = workAreaMaintenanceDTO.getServiceId();

        if (newWorkAreaId != null) {
            WorkArea workArea = workAreaRepository.findById(workAreaId)
                    .orElseThrow(() -> new NoSuchEntityException("Work area with id=" + workAreaId + " not found"));
            existingRecord.setWorkArea(workArea);
            existingRecord.setWorkAreaId(workArea.getId());
        }

        if (newServiceId != null) {
            Maintenance service = maintenanceRepository
                    .findById(serviceId)
                    .orElseThrow(() -> new NoSuchEntityException(
                            "Service with id=" + serviceId + " not found"));
            existingRecord.setService(service);
            existingRecord.setServiceId(service.getId());
        }

        return workAreaMaintenanceRepository.save(existingRecord);
    }
     */

    @Override
    public void deleteById(Long workAreaId, Long serviceId) {
        WorkAreaMaintenanceId id = new WorkAreaMaintenanceId();
        id.setWorkAreaId(workAreaId);
        id.setServiceId(serviceId);

        WorkAreaMaintenance existingRecord = workAreaMaintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with work area id=" + workAreaId +
                        " and service id=" + serviceId + " not found"));

        workAreaMaintenanceRepository.delete(existingRecord);
    }
}
