package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.MaintenanceConsumableMaterialDTO;
import com.mxrpheus.carservice.model.MaintenanceConsumableMaterial;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaintenanceConsumableMaterialMapper {
    MaintenanceConsumableMaterialDTO toDto(MaintenanceConsumableMaterial maintenanceConsumableMaterial);
    List<MaintenanceConsumableMaterialDTO> toDtoList(List<MaintenanceConsumableMaterial> maintenanceConsumableMaterials);

    MaintenanceConsumableMaterial toEntity(MaintenanceConsumableMaterialDTO maintenanceConsumableMaterialDTO);
}
