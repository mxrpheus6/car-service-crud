package com.mxrpheus.carservice.mapper;

import com.mxrpheus.carservice.dto.EmployeeDTO;
import com.mxrpheus.carservice.model.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(source = "position.id", target = "positionId")
    EmployeeDTO toDto(Employee employee);
    List<EmployeeDTO> toDtoList(List<Employee> employees);

    Employee toEntity(EmployeeDTO employeeDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployee(EmployeeDTO employeeDTO, @MappingTarget Employee employee);
}
