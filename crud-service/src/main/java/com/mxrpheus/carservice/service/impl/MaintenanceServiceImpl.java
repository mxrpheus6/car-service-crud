package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.MaintenanceDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.MaintenanceMapper;
import com.mxrpheus.carservice.model.Maintenance;
import com.mxrpheus.carservice.repository.MaintenanceRepository;
import com.mxrpheus.carservice.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final MaintenanceMapper maintenanceMapper;

    @Override
    public List<MaintenanceDTO> getAllServices() {
        return maintenanceMapper.toDtoList(maintenanceRepository.findAll());
    }

    @Override
    public MaintenanceDTO getServiceById(Long id) {
        return maintenanceMapper.toDto(maintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + id + " not found")));
    }

    @Override
    public MaintenanceDTO createService(MaintenanceDTO maintenanceDTO) {
        maintenanceDTO.setId(null);
        Maintenance maintenance = maintenanceMapper.toEntity(maintenanceDTO);
        return maintenanceMapper.toDto(maintenanceRepository.save(maintenance));
    }

    @Override
    public MaintenanceDTO updateService(Long id, MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + id + " not found"));

        maintenanceDTO.setId(null);
        maintenanceMapper.updateService(maintenanceDTO, maintenance);

        return maintenanceMapper.toDto(maintenanceRepository.save(maintenance));
    }

    @Override
    public void deleteServiceById(Long id) {
        Maintenance maintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + id + " not found"));

        maintenanceRepository.delete(maintenance);
    }

}
