package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.CompletedMaintenanceEmployeeDTO;
import com.mxrpheus.carservice.model.CompletedMaintenanceEmployee;
import com.mxrpheus.carservice.service.CompletedMaintenanceEmployeeService;
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
@RequestMapping("api/completed-service-employees")
@RequiredArgsConstructor
public class CompletedMaintenanceEmployeeController {

    private final CompletedMaintenanceEmployeeService completedMaintenanceEmployeeService;

    @GetMapping
    public ResponseEntity<List<CompletedMaintenanceEmployee>> getAll() {
        return ResponseEntity.ok(completedMaintenanceEmployeeService.getAll());
    }

    @GetMapping("/{completedServiceId}/{employeeId}")
    public ResponseEntity<CompletedMaintenanceEmployee> getById(@PathVariable Long completedServiceId,
                                                                @PathVariable Long employeeId) {
        return ResponseEntity.ok(completedMaintenanceEmployeeService.getById(completedServiceId, employeeId));
    }

    @PostMapping
    public ResponseEntity<CompletedMaintenanceEmployee> create(@RequestBody CompletedMaintenanceEmployeeDTO completedMaintenanceEmployeeDTO) {
        return ResponseEntity.ok(completedMaintenanceEmployeeService.create(completedMaintenanceEmployeeDTO));
    }

    @DeleteMapping("/{completedServiceId}/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable Long completedServiceId,
                                       @PathVariable Long employeeId) {
        completedMaintenanceEmployeeService.deleteById(completedServiceId, employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
