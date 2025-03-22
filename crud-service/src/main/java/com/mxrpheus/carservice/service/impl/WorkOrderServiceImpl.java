package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.WorkOrderDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.WorkOrderMapper;
import com.mxrpheus.carservice.model.Car;
import com.mxrpheus.carservice.model.WorkOrder;
import com.mxrpheus.carservice.repository.CarRepository;
import com.mxrpheus.carservice.repository.WorkOrderRepository;
import com.mxrpheus.carservice.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final CarRepository carRepository;
    private final WorkOrderMapper workOrderMapper;


    @Override
    public List<WorkOrderDTO> getAllWorkOrders() {
        return workOrderMapper.toDtoList(workOrderRepository.findAll());
    }

    @Override
    public WorkOrderDTO getWorkOrderById(Long id) {
        return workOrderMapper.toDto(workOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work order with id=" + id + " not found")));
    }

    @Override
    public WorkOrderDTO createWorkOrder(WorkOrderDTO workOrderDTO) {
        Car car = carRepository.findById(workOrderDTO.getCarId())
                .orElseThrow(() -> new NoSuchEntityException("Car with id=" + workOrderDTO.getCarId() + " not found"));

        workOrderDTO.setId(null);
        WorkOrder workOrder = workOrderMapper.toEntity(workOrderDTO);
        workOrder.setCar(car);

        return workOrderMapper.toDto(workOrderRepository.save(workOrder));
    }

    @Override
    public WorkOrderDTO updateWorkOrder(Long id, WorkOrderDTO workOrderDTO) {
        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work order with id=" + id + " not found"));

        workOrderDTO.setId(null);
        workOrderMapper.updateWorkOrder(workOrderDTO, workOrder);

        if (workOrderDTO.getCarId() != null) {
            Car car = carRepository.findById(workOrderDTO.getCarId())
                    .orElseThrow(() -> new NoSuchEntityException("Car with id=" + workOrderDTO.getCarId() + " not found"));
            workOrder.setCar(car);
        }

        return workOrderMapper.toDto(workOrderRepository.save(workOrder));
    }

    @Override
    public void deleteWorkOrderById(Long id) {
        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work order with id=" + id + " not found"));

        workOrderRepository.delete(workOrder);
    }
}
