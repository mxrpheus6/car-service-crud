package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.MaintenanceEmployee;
import com.mxrpheus.carservice.model.id.MaintenanceEmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceEmployeeRepository extends JpaRepository<MaintenanceEmployee, MaintenanceEmployeeId> {
}
