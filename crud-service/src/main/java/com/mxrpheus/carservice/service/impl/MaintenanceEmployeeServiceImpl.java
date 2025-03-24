package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.MaintenanceEmployeeDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.model.Employee;
import com.mxrpheus.carservice.model.Maintenance;
import com.mxrpheus.carservice.model.MaintenanceEmployee;
import com.mxrpheus.carservice.model.id.MaintenanceEmployeeId;
import com.mxrpheus.carservice.repository.EmployeeRepository;
import com.mxrpheus.carservice.repository.MaintenanceEmployeeRepository;
import com.mxrpheus.carservice.repository.MaintenanceRepository;
import com.mxrpheus.carservice.service.MaintenanceEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceEmployeeServiceImpl implements MaintenanceEmployeeService {

    private final MaintenanceEmployeeRepository maintenanceEmployeeRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<MaintenanceEmployee> getAll() {
        return maintenanceEmployeeRepository.findAll();
    }

    @Override
    public MaintenanceEmployee getById(Long serviceId, Long employeeId) {
        MaintenanceEmployeeId id = new MaintenanceEmployeeId();
        id.setServiceId(serviceId);
        id.setEmployeeId(employeeId);

        return maintenanceEmployeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with service id=" + serviceId +
                        " and employee id=" + employeeId + " not found"));
    }

    @Override
    public MaintenanceEmployee create(MaintenanceEmployeeDTO maintenanceEmployeeDTO) {
        Long serviceId = maintenanceEmployeeDTO.getServiceId();
        Long employeeId = maintenanceEmployeeDTO.getEmployeeId();

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchEntityException("Employee with id=" + employeeId + " not found"));

        Maintenance service = maintenanceRepository
                .findById(serviceId)
                .orElseThrow(() -> new NoSuchEntityException(
                        "Service with id=" + serviceId + " not found"));

        MaintenanceEmployee maintenanceEmployee = new MaintenanceEmployee();
        maintenanceEmployee.setService(service);
        maintenanceEmployee.setEmployee(employee);

        return maintenanceEmployeeRepository.save(maintenanceEmployee);
    }

    @Override
    public void deleteById(Long serviceId, Long employeeId) {
        MaintenanceEmployeeId id = new MaintenanceEmployeeId();
        id.setServiceId(serviceId);
        id.setEmployeeId(employeeId);

        MaintenanceEmployee existingRecord = maintenanceEmployeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Record with service id=" + serviceId +
                        " and employee id=" + employeeId + " not found"));

        maintenanceEmployeeRepository.delete(existingRecord);
    }
}
