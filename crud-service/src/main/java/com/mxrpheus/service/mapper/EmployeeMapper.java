package com.mxrpheus.service.mapper;

import com.mxrpheus.service.dto.EmployeeDTO;
import com.mxrpheus.service.model.Employee;
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
