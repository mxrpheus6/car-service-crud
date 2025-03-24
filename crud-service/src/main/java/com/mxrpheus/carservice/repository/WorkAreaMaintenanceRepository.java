package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.WorkAreaMaintenance;
import com.mxrpheus.carservice.model.id.WorkAreaMaintenanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAreaMaintenanceRepository extends JpaRepository<WorkAreaMaintenance, WorkAreaMaintenanceId> {
}
