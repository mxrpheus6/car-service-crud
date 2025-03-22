package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.WorkOrderDTO;

import java.util.List;

public interface WorkOrderService {
    List<WorkOrderDTO> getAllWorkOrders();
    WorkOrderDTO getWorkOrderById(Long id);
    WorkOrderDTO createWorkOrder(WorkOrderDTO workOrderDTO);
    WorkOrderDTO updateWorkOrder(Long id, WorkOrderDTO workOrderDTO);
    void deleteWorkOrderById(Long id);
}
