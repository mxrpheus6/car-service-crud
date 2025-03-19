package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.PositionDTO;
import com.mxrpheus.carservice.model.Position;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionDTO toDto(Position position);
    List<PositionDTO> toDtoList(List<Position> positions);

    Position toEntity(PositionDTO positionDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePosition(PositionDTO positionDTO, @MappingTarget Position position);
}
