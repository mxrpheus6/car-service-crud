package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.WorkOrderDTO;
import com.mxrpheus.carservice.model.WorkOrder;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkOrderMapper {
    @Mapping(source = "car.id", target = "carId")
    WorkOrderDTO toDto(WorkOrder workOrder);
    List<WorkOrderDTO> toDtoList(List<WorkOrder> workOrders);

    WorkOrder toEntity(WorkOrderDTO workOrderDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateWorkOrder(WorkOrderDTO workOrderDTO, @MappingTarget WorkOrder workOrder);
}
