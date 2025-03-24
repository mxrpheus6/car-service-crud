package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.CompletedMaintenanceEmployeeDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.model.CompletedMaintenance;
import com.mxrpheus.carservice.model.CompletedMaintenanceEmployee;
import com.mxrpheus.carservice.model.Employee;
import com.mxrpheus.carservice.model.id.CompletedMaintenanceEmployeeId;
import com.mxrpheus.carservice.repository.CompletedMaintenanceEmployeeRepository;
import com.mxrpheus.carservice.repository.CompletedMaintenanceRepository;
import com.mxrpheus.carservice.repository.EmployeeRepository;
import com.mxrpheus.carservice.service.CompletedMaintenanceEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompletedMaintenanceEmployeeServiceImpl implements CompletedMaintenanceEmployeeService {

    private final CompletedMaintenanceEmployeeRepository completedMaintenanceEmployeeRepository;
    private final CompletedMaintenanceRepository completedMaintenanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<CompletedMaintenanceEmployee> getAll() {
        return completedMaintenanceEmployeeRepository.findAll();
    }

    @Override
    public CompletedMaintenanceEmployee getById(Long completedServiceId, Long employeeId) {
        CompletedMaintenanceEmployeeId id = new CompletedMaintenanceEmployeeId();
        id.setCompletedServiceId(completedServiceId);
        id.setEmployeeId(employeeId);

        return completedMaintenanceEmployeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with completed service id=" + completedServiceId +
                        " and employee id=" + employeeId + " not found"));
    }

    @Override
    public CompletedMaintenanceEmployee create(CompletedMaintenanceEmployeeDTO completedMaintenanceEmployeeDTO) {
        Long completedServiceId = completedMaintenanceEmployeeDTO.getCompletedServiceId();
        Long employeeId = completedMaintenanceEmployeeDTO.getEmployeeId();

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchEntityException("Employee with id=" + employeeId + " not found"));

        CompletedMaintenance completedService = completedMaintenanceRepository
                .findById(completedServiceId)
                .orElseThrow(() -> new NoSuchEntityException(
                        "Completed service with id=" + completedMaintenanceEmployeeDTO + " not found"));

        CompletedMaintenanceEmployee completedMaintenanceEmployee = new CompletedMaintenanceEmployee();
        completedMaintenanceEmployee.setCompletedService(completedService);
        completedMaintenanceEmployee.setEmployee(employee);

        return completedMaintenanceEmployeeRepository.save(completedMaintenanceEmployee);
    }

    @Override
    public void deleteById(Long completedServiceId, Long employeeId) {
        CompletedMaintenanceEmployeeId id = new CompletedMaintenanceEmployeeId();
        id.setCompletedServiceId(completedServiceId);
        id.setEmployeeId(employeeId);

        CompletedMaintenanceEmployee existingRecord = completedMaintenanceEmployeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with completed service id=" + completedServiceId +
                        " and employee id=" + employeeId + " not found"));

        completedMaintenanceEmployeeRepository.delete(existingRecord);
    }
}
