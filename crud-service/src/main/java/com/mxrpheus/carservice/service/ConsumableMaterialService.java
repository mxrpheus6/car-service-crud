package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.ConsumableMaterialDTO;

import java.util.List;

public interface ConsumableMaterialService {
    List<ConsumableMaterialDTO> getAllConsumableMaterials();
    ConsumableMaterialDTO getConsumableMaterialById(Long id);
    ConsumableMaterialDTO createConsumableMaterial(ConsumableMaterialDTO consumableMaterialDTO);
    ConsumableMaterialDTO updateConsumableMaterial(Long id, ConsumableMaterialDTO consumableMaterialDTO);
    void deleteConsumableMaterialById(Long id);
}
