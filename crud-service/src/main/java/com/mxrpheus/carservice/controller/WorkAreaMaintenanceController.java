package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.WorkAreaMaintenanceDTO;
import com.mxrpheus.carservice.model.WorkAreaMaintenance;
import com.mxrpheus.carservice.service.WorkAreaMaintenanceService;
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
@RequestMapping("api/work-area-service")
@RequiredArgsConstructor
public class WorkAreaMaintenanceController {

    private final WorkAreaMaintenanceService workAreaMaintenanceService;

    @GetMapping
    public ResponseEntity<List<WorkAreaMaintenance>> getAll() {
        return ResponseEntity.ok(workAreaMaintenanceService.getAll());
    }

    @GetMapping("/{workAreaId}/{serviceId}")
    public ResponseEntity<WorkAreaMaintenance> getById(@PathVariable Long workAreaId,
                                                       @PathVariable Long serviceId) {
        return ResponseEntity.ok(workAreaMaintenanceService.getById(workAreaId, serviceId));
    }

    @PostMapping
    public ResponseEntity<WorkAreaMaintenance> create(@RequestBody WorkAreaMaintenanceDTO workAreaMaintenanceDTO) {
        return ResponseEntity.ok(workAreaMaintenanceService.create(workAreaMaintenanceDTO));
    }

    @DeleteMapping("/{workAreaId}/{serviceId}")
    public ResponseEntity<Void> delete(@PathVariable Long workAreaId,
                                       @PathVariable Long serviceId) {
        workAreaMaintenanceService.deleteById(workAreaId, serviceId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
