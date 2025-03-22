package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.MaintenanceDTO;
import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import com.mxrpheus.carservice.service.MaintenanceService;
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
@RequestMapping("api/services")
@RequiredArgsConstructor
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<List<MaintenanceDTO>> getAllServices() {
        return ResponseEntity.ok(maintenanceService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceService.getServiceById(id));
    }

    @PostMapping
    public ResponseEntity<MaintenanceDTO> createService(@Validated(ValidationGroups.OnCreate.class) @RequestBody MaintenanceDTO maintenanceDTO) {
        return ResponseEntity.ok(maintenanceService.createService(maintenanceDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> updateService(@PathVariable Long id,
                                                        @Validated(ValidationGroups.OnUpdate.class) @RequestBody MaintenanceDTO maintenanceDTO) {
        return ResponseEntity.ok(maintenanceService.updateService(id, maintenanceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceById(@PathVariable Long id) {
        maintenanceService.deleteServiceById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
