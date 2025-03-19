package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.EmployeeDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.EmployeeMapper;
import com.mxrpheus.carservice.model.Employee;
import com.mxrpheus.carservice.model.Position;
import com.mxrpheus.carservice.repository.EmployeeRepository;
import com.mxrpheus.carservice.repository.PositionRepository;
import com.mxrpheus.carservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeMapper.toDto(employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Employee with id=" + id + " not found")));
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Position position = positionRepository.findById(employeeDTO.getPositionId())
                .orElseThrow(() -> new NoSuchEntityException("Position with id=" + employeeDTO.getPositionId() + " not found"));

        employeeDTO.setId(null);
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employee.setPosition(position);

        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Employee with id=" + id + " not found"));

        employeeDTO.setId(null);
        employeeMapper.updateEmployee(employeeDTO, employee);

        if (employeeDTO.getPositionId() != null) {
            Position position = positionRepository.findById(employeeDTO.getPositionId())
                    .orElseThrow(() -> new NoSuchEntityException("Position with id=" + employeeDTO.getPositionId() + " not found"));
            employee.setPosition(position);
        }

        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Employee with id=" + id + " not found"));

        employeeRepository.delete(employee);
    }
}
