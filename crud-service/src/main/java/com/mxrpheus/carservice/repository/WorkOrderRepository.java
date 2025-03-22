package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
