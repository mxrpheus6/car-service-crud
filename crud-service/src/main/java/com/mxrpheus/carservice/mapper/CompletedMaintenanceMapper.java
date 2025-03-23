package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.CompletedMaintenanceDTO;
import com.mxrpheus.carservice.model.CompletedMaintenance;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompletedMaintenanceMapper {
    @Mapping(source = "workOrder.id", target = "workOrderId")
    @Mapping(source = "workArea.id", target = "workAreaId")
    @Mapping(source = "service.id", target = "serviceId")
    CompletedMaintenanceDTO toDto(CompletedMaintenance completedMaintenance);
    List<CompletedMaintenanceDTO> toDtoList(List<CompletedMaintenance> completedMaintenances);

    CompletedMaintenance toEntity(CompletedMaintenanceDTO completedMaintenanceDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCompletedMaintenance(CompletedMaintenanceDTO completedMaintenanceDTO, @MappingTarget CompletedMaintenance completedMaintenance);
}
