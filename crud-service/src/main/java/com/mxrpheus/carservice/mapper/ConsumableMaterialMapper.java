package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.ConsumableMaterialDTO;
import com.mxrpheus.carservice.model.ConsumableMaterial;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsumableMaterialMapper {
    ConsumableMaterialDTO toDto(ConsumableMaterial consumableMaterial);
    List<ConsumableMaterialDTO> toDtoList(List<ConsumableMaterial> consumableMaterials);

    ConsumableMaterial toEntity(ConsumableMaterialDTO ConsumableMaterialDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateConsumableMaterial(ConsumableMaterialDTO consumableMaterialDTO, @MappingTarget ConsumableMaterial consumableMaterial);
}
