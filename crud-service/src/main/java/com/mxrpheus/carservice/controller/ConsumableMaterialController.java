package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.ConsumableMaterialDTO;
import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import com.mxrpheus.carservice.service.ConsumableMaterialService;
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
@RequestMapping("api/consumable-materials")
@RequiredArgsConstructor
public class ConsumableMaterialController {

    private final ConsumableMaterialService consumableMaterialService;

    @GetMapping
    public ResponseEntity<List<ConsumableMaterialDTO>> getAllConsumableMaterials() {
        return ResponseEntity.ok(consumableMaterialService.getAllConsumableMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumableMaterialDTO> getConsumableMaterialById(@PathVariable Long id) {
        return ResponseEntity.ok(consumableMaterialService.getConsumableMaterialById(id));
    }

    @PostMapping
    public ResponseEntity<ConsumableMaterialDTO> createConsumableMaterial(@Validated(ValidationGroups.OnCreate.class) @RequestBody ConsumableMaterialDTO consumableMaterialDTO) {
        return ResponseEntity.ok(consumableMaterialService.createConsumableMaterial(consumableMaterialDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ConsumableMaterialDTO> updateConsumableMaterial(@PathVariable Long id,
                                                      @Validated(ValidationGroups.OnUpdate.class) @RequestBody ConsumableMaterialDTO consumableMaterialDTO) {
        return ResponseEntity.ok(consumableMaterialService.updateConsumableMaterial(id, consumableMaterialDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumableMaterialById(@PathVariable Long id) {
        consumableMaterialService.deleteConsumableMaterialById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
