package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.CompletedMaintenanceEmployee;
import com.mxrpheus.carservice.model.id.CompletedMaintenanceEmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedMaintenanceEmployeeRepository extends JpaRepository<CompletedMaintenanceEmployee, CompletedMaintenanceEmployeeId> {
}
