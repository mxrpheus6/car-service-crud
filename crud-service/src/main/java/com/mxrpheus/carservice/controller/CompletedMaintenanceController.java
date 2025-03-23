package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.CompletedMaintenanceDTO;
import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import com.mxrpheus.carservice.service.CompletedMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/completed-services")
@RequiredArgsConstructor
public class CompletedMaintenanceController {

    private final CompletedMaintenanceService completedMaintenanceService;

    @GetMapping
    public ResponseEntity<List<CompletedMaintenanceDTO>> getAllCompletedMaintenances() {
        return ResponseEntity.ok(completedMaintenanceService.getAllCompletedMaintenances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompletedMaintenanceDTO> getCompletedMaintenanceById(@PathVariable Long id) {
        return ResponseEntity.ok(completedMaintenanceService.getCompletedMaintenanceById(id));
    }

    @PostMapping
    public ResponseEntity<CompletedMaintenanceDTO> createCompletedMaintenance(@Validated(ValidationGroups.OnCreate.class) @RequestBody CompletedMaintenanceDTO completedMaintenanceDTO) {
        return ResponseEntity.ok(completedMaintenanceService.createCompletedMaintenance(completedMaintenanceDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CompletedMaintenanceDTO> updateCompletedMaintenance(@PathVariable Long id,
                                                                          @Validated(ValidationGroups.OnUpdate.class) @RequestBody CompletedMaintenanceDTO completedMaintenanceDTO) {
        return ResponseEntity.ok(completedMaintenanceService.updateCompletedMaintenance(id, completedMaintenanceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompletedMaintenanceById(@PathVariable Long id) {
        completedMaintenanceService.deleteCompletedMaintenanceById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
