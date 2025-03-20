package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.WorkAreaDTO;
import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import com.mxrpheus.carservice.service.WorkAreaService;
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
@RequestMapping("api/work-areas")
@RequiredArgsConstructor
public class WorkAreaController {

    private final WorkAreaService workAreaService;

    @GetMapping
    public ResponseEntity<List<WorkAreaDTO>> getAllPositions() {
        return ResponseEntity.ok(workAreaService.getAllWorkAreas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkAreaDTO> getPositionById(@PathVariable Long id) {
        return ResponseEntity.ok(workAreaService.getWorkAreaById(id));
    }

    @PostMapping
    public ResponseEntity<WorkAreaDTO> createPosition(@Validated(ValidationGroups.OnCreate.class) @RequestBody WorkAreaDTO workAreaDTO) {
        return ResponseEntity.ok(workAreaService.createWorkArea(workAreaDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WorkAreaDTO> updatePosition(@PathVariable Long id,
                                                          @Validated(ValidationGroups.OnUpdate.class) @RequestBody WorkAreaDTO workAreaDTO) {
        return ResponseEntity.ok(workAreaService.updateWorkArea(id, workAreaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePositionById(@PathVariable Long id) {
        workAreaService.deleteWorkAreaById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
