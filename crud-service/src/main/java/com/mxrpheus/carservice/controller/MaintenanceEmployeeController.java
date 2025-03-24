package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.MaintenanceEmployeeDTO;
import com.mxrpheus.carservice.model.MaintenanceEmployee;
import com.mxrpheus.carservice.service.MaintenanceEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/service-employees")
@RequiredArgsConstructor
public class MaintenanceEmployeeController {

    private final MaintenanceEmployeeService maintenanceEmployeeService;

    @GetMapping
    public ResponseEntity<List<MaintenanceEmployee>> getAll() {
        return ResponseEntity.ok(maintenanceEmployeeService.getAll());
    }

    @GetMapping("/{serviceId}/{employeeId}")
    public ResponseEntity<MaintenanceEmployee> getById(@PathVariable Long serviceId,
                                                       @PathVariable Long employeeId) {
        return ResponseEntity.ok(maintenanceEmployeeService.getById(serviceId, employeeId));
    }

    @PostMapping
    public ResponseEntity<MaintenanceEmployee> create(@RequestBody MaintenanceEmployeeDTO maintenanceEmployeeDTO) {
        return ResponseEntity.ok(maintenanceEmployeeService.create(maintenanceEmployeeDTO));
    }

    @DeleteMapping("/{serviceId}/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable Long serviceId,
                                       @PathVariable Long employeeId) {
        maintenanceEmployeeService.deleteById(serviceId, employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
