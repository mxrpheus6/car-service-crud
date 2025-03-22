package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.MaintenanceDTO;
import com.mxrpheus.carservice.model.Maintenance;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {
    MaintenanceDTO toDto(Maintenance maintenance);
    List<MaintenanceDTO> toDtoList(List<Maintenance> serviceEntities);

    Maintenance toEntity(MaintenanceDTO maintenanceDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateService(MaintenanceDTO maintenanceDTO, @MappingTarget Maintenance maintenance);
}
