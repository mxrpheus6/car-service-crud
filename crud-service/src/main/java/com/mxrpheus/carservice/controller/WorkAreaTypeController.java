package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.WorkAreaTypeDTO;
import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import com.mxrpheus.carservice.service.WorkAreaTypeService;
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
@RequestMapping("api/work-area-types")
@RequiredArgsConstructor
public class WorkAreaTypeController {

    private final WorkAreaTypeService workAreaTypeService;

    @GetMapping
    public ResponseEntity<List<WorkAreaTypeDTO>> getAllPositions() {
        return ResponseEntity.ok(workAreaTypeService.getAllWorkAreaTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkAreaTypeDTO> getPositionById(@PathVariable Long id) {
        return ResponseEntity.ok(workAreaTypeService.getWorkAreaTypeById(id));
    }

    @PostMapping
    public ResponseEntity<WorkAreaTypeDTO> createPosition(@Validated(ValidationGroups.OnCreate.class) @RequestBody WorkAreaTypeDTO workAreaTypeDTO) {
        return ResponseEntity.ok(workAreaTypeService.createWorkAreaType(workAreaTypeDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WorkAreaTypeDTO> updatePosition(@PathVariable Long id,
                                                      @Validated(ValidationGroups.OnUpdate.class) @RequestBody WorkAreaTypeDTO workAreaTypeDTO) {
        return ResponseEntity.ok(workAreaTypeService.updateWorkAreaType(id, workAreaTypeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePositionById(@PathVariable Long id) {
        workAreaTypeService.deleteWorkAreaTypeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
