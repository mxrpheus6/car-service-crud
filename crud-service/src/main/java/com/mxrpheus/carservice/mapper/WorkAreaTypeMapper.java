package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.WorkAreaTypeDTO;
import com.mxrpheus.carservice.model.WorkAreaType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkAreaTypeMapper {
    WorkAreaTypeDTO toDto(WorkAreaType workAreaType);
    List<WorkAreaTypeDTO> toDtoList(List<WorkAreaType> workAreaTypes);

    WorkAreaType toEntity(WorkAreaTypeDTO workAreaTypeDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateWorkAreaType(WorkAreaTypeDTO workAreaTypeDTO, @MappingTarget WorkAreaType workArea);
}
