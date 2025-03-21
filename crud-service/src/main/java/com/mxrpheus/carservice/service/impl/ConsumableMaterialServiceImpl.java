package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.ConsumableMaterialDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.ConsumableMaterialMapper;
import com.mxrpheus.carservice.model.ConsumableMaterial;
import com.mxrpheus.carservice.model.ServiceEntity;
import com.mxrpheus.carservice.repository.ConsumableMaterialRepository;
import com.mxrpheus.carservice.service.ConsumableMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumableMaterialServiceImpl implements ConsumableMaterialService {

    private final ConsumableMaterialRepository consumableMaterialRepository;
    private final ConsumableMaterialMapper consumableMaterialMapper;

    @Override
    public List<ConsumableMaterialDTO> getAllConsumableMaterials() {
        return consumableMaterialMapper.toDtoList(consumableMaterialRepository.findAll());
    }

    @Override
    public ConsumableMaterialDTO getConsumableMaterialById(Long id) {
        return consumableMaterialMapper.toDto(consumableMaterialRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Consumable material with id=" + id + " not found")));
    }

    @Override
    public ConsumableMaterialDTO createConsumableMaterial(ConsumableMaterialDTO consumableMaterialDTO) {
        consumableMaterialDTO.setId(null);
        ConsumableMaterial consumableMaterial = consumableMaterialMapper.toEntity(consumableMaterialDTO);
        return consumableMaterialMapper.toDto(consumableMaterialRepository.save(consumableMaterial));
    }

    @Override
    public ConsumableMaterialDTO updateConsumableMaterial(Long id, ConsumableMaterialDTO consumableMaterialDTO) {
        ConsumableMaterial consumableMaterial = consumableMaterialRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Consumable material with id=" + id + " not found"));

        consumableMaterialDTO.setId(null);
        consumableMaterialMapper.updateConsumableMaterial(consumableMaterialDTO, consumableMaterial);

        return consumableMaterialMapper.toDto(consumableMaterialRepository.save(consumableMaterial));
    }

    @Override
    public void deleteConsumableMaterialById(Long id) {
        ConsumableMaterial consumableMaterial = consumableMaterialRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Consumable material with id=" + id + " not found"));

        consumableMaterialRepository.delete(consumableMaterial);
    }
}
