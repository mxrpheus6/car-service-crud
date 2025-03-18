package com.mxrpheus.service.mapper;

import com.mxrpheus.service.dto.CarDTO;
import com.mxrpheus.service.model.Car;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "clientId", source = "client.id")
    CarDTO toDto(Car car);
    List<CarDTO> toDtoList(List<Car> cars);

    @Mapping(target = "client.id", source = "clientId")
    Car toEntity(CarDTO carDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCar(CarDTO carDTO, @MappingTarget Car car);
}
