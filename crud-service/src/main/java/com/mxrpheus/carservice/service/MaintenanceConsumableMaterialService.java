package com.mxrpheus.carservice.service;


import com.mxrpheus.carservice.dto.MaintenanceConsumableMaterialDTO;
import com.mxrpheus.carservice.model.MaintenanceConsumableMaterial;

import java.math.BigDecimal;
import java.util.List;

public interface MaintenanceConsumableMaterialService {
    List<MaintenanceConsumableMaterial> getAll();
    MaintenanceConsumableMaterial getById(Long maintenanceId, Long consumableMaterialId);
    MaintenanceConsumableMaterial create(MaintenanceConsumableMaterialDTO maintenanceConsumableMaterialDTO);
    MaintenanceConsumableMaterial update(Long maintenanceId, Long consumableMaterialId, BigDecimal amount);
    void deleteById(Long maintenanceId, Long consumableMaterialId);
}
