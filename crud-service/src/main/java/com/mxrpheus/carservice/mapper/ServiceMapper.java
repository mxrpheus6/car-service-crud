package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.ServiceDTO;
import com.mxrpheus.carservice.model.ServiceEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceDTO toDto(ServiceEntity serviceEntity);
    List<ServiceDTO> toDtoList(List<ServiceEntity> serviceEntities);

    ServiceEntity toEntity(ServiceDTO serviceDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateService(ServiceDTO serviceDTO, @MappingTarget ServiceEntity serviceEntity);
}
