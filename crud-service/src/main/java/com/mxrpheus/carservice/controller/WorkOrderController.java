package com.mxrpheus.carservice.controller;

import com.mxrpheus.carservice.dto.WorkOrderDTO;
import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import com.mxrpheus.carservice.service.WorkOrderService;
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
@RequestMapping("api/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    @GetMapping
    public ResponseEntity<List<WorkOrderDTO>> getAllWorkOrders() {
        return ResponseEntity.ok(workOrderService.getAllWorkOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderDTO> getWorkOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(workOrderService.getWorkOrderById(id));
    }

    @PostMapping
    public ResponseEntity<WorkOrderDTO> createWorkOrder(@Validated(ValidationGroups.OnCreate.class) @RequestBody WorkOrderDTO workOrderDTO) {
        return ResponseEntity.ok(workOrderService.createWorkOrder(workOrderDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WorkOrderDTO> updateWorkOrder(@PathVariable Long id,
                                                  @Validated(ValidationGroups.OnUpdate.class) @RequestBody WorkOrderDTO workOrderDTO) {
        return ResponseEntity.ok(workOrderService.updateWorkOrder(id, workOrderDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkOrderById(@PathVariable Long id) {
        workOrderService.deleteWorkOrderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
