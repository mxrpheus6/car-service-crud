package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.MaintenanceConsumableMaterialDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.model.ConsumableMaterial;
import com.mxrpheus.carservice.model.Maintenance;
import com.mxrpheus.carservice.model.MaintenanceConsumableMaterial;
import com.mxrpheus.carservice.model.id.MaintenanceConsumableMaterialId;
import com.mxrpheus.carservice.repository.ConsumableMaterialRepository;
import com.mxrpheus.carservice.repository.MaintenanceConsumableMaterialRepository;
import com.mxrpheus.carservice.repository.MaintenanceRepository;
import com.mxrpheus.carservice.service.MaintenanceConsumableMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceConsumableMaterialServiceImpl implements MaintenanceConsumableMaterialService {

    private final MaintenanceConsumableMaterialRepository maintenanceConsumableMaterialRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final ConsumableMaterialRepository consumableMaterialRepository;

    @Override
    public List<MaintenanceConsumableMaterial> getAll() {
        return maintenanceConsumableMaterialRepository.findAll();
    }

    @Override
    public MaintenanceConsumableMaterial getById(Long maintenanceId, Long consumableMaterialId) {
        MaintenanceConsumableMaterialId id = new MaintenanceConsumableMaterialId();
        id.setServiceId(maintenanceId);
        id.setConsumableMaterialId(consumableMaterialId);

        return maintenanceConsumableMaterialRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with service id=" + maintenanceId +
                        " and consumable material id=" + consumableMaterialId + " not found"));
    }

    @Override
    public MaintenanceConsumableMaterial create(MaintenanceConsumableMaterialDTO maintenanceConsumableMaterialDTO) {
        Long maintenanceId = maintenanceConsumableMaterialDTO.getServiceId();
        Long consumableMaterialId = maintenanceConsumableMaterialDTO.getConsumableMaterialId();
        BigDecimal amount = maintenanceConsumableMaterialDTO.getAmount();

        Maintenance maintenance = maintenanceRepository.findById(maintenanceId)
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + maintenanceId + " not found"));

        ConsumableMaterial consumableMaterial = consumableMaterialRepository
                .findById(consumableMaterialId)
                .orElseThrow(() -> new NoSuchEntityException(
                        "Consumable Material with id=" + consumableMaterialId + " not found"));

        MaintenanceConsumableMaterial maintenanceConsumableMaterial = new MaintenanceConsumableMaterial();
        maintenanceConsumableMaterial.setService(maintenance);
        maintenanceConsumableMaterial.setConsumableMaterial(consumableMaterial);
        maintenanceConsumableMaterial.setAmount(amount);

        return maintenanceConsumableMaterialRepository.save(maintenanceConsumableMaterial);
    }

    @Override
    public MaintenanceConsumableMaterial update(Long maintenanceId, Long consumableMaterialId,
                                                BigDecimal amount) {

        MaintenanceConsumableMaterialId id = new MaintenanceConsumableMaterialId();
        id.setServiceId(maintenanceId);
        id.setConsumableMaterialId(consumableMaterialId);

        MaintenanceConsumableMaterial existingRecord = maintenanceConsumableMaterialRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with service id=" + maintenanceId +
                        " and consumable material id=" + consumableMaterialId + " not found"));

        if (amount != null) {
            existingRecord.setAmount(amount);
        }

        return maintenanceConsumableMaterialRepository.save(existingRecord);
    }

    @Override
    public void deleteById(Long maintenanceId, Long consumableMaterialId) {
        MaintenanceConsumableMaterialId id = new MaintenanceConsumableMaterialId();
        id.setServiceId(maintenanceId);
        id.setConsumableMaterialId(consumableMaterialId);

        MaintenanceConsumableMaterial existingRecord = maintenanceConsumableMaterialRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with service id=" + maintenanceId +
                        " and consumable material id=" + consumableMaterialId + " not found"));

        maintenanceConsumableMaterialRepository.delete(existingRecord);
    }
}
