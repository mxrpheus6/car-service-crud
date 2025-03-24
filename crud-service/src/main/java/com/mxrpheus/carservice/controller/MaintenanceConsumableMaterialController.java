package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.MaintenanceConsumableMaterialDTO;
import com.mxrpheus.carservice.model.MaintenanceConsumableMaterial;
import com.mxrpheus.carservice.service.MaintenanceConsumableMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/service-consumable-materials")
@RequiredArgsConstructor
public class MaintenanceConsumableMaterialController {

    private final MaintenanceConsumableMaterialService maintenanceConsumableMaterialService;

    @GetMapping
    public ResponseEntity<List<MaintenanceConsumableMaterial>> getAll() {
        return ResponseEntity.ok(maintenanceConsumableMaterialService.getAll());
    }

    @GetMapping("/{maintenanceId}/{consumableMaterialId}")
    public ResponseEntity<MaintenanceConsumableMaterial> getById(@PathVariable Long maintenanceId, @PathVariable Long consumableMaterialId) {
        return ResponseEntity.ok(maintenanceConsumableMaterialService.getById(maintenanceId, consumableMaterialId));
    }

    @PostMapping
    public ResponseEntity<MaintenanceConsumableMaterial> create(@RequestBody MaintenanceConsumableMaterialDTO maintenanceConsumableMaterialDTO) {
        return ResponseEntity.ok(maintenanceConsumableMaterialService.create(maintenanceConsumableMaterialDTO));
    }

    @PatchMapping("/{maintenanceId}/{consumableMaterialId}")
    public ResponseEntity<MaintenanceConsumableMaterial> update(
            @PathVariable Long maintenanceId,
            @PathVariable Long consumableMaterialId,
            @RequestParam(required = false) BigDecimal amount) {
        return ResponseEntity.ok(maintenanceConsumableMaterialService.update(maintenanceId, consumableMaterialId, amount));
    }

    @DeleteMapping("/{maintenanceId}/{consumableMaterialId}")
    public ResponseEntity<Void> delete(@PathVariable Long maintenanceId, @PathVariable Long consumableMaterialId) {
        maintenanceConsumableMaterialService.deleteById(maintenanceId, consumableMaterialId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
