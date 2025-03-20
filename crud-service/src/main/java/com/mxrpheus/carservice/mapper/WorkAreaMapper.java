package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.WorkAreaDTO;
import com.mxrpheus.carservice.model.WorkArea;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkAreaMapper {
    @Mapping(source = "workAreaType.id", target = "workAreaTypeId")
    WorkAreaDTO toDto(WorkArea workArea);
    List<WorkAreaDTO> toDtoList(List<WorkArea> workAreas);

    WorkArea toEntity(WorkAreaDTO workAreaDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateWorkArea(WorkAreaDTO workAreaDTO, @MappingTarget WorkArea workArea);
}
