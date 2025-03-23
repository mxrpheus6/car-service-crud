package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.CompletedMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedMaintenanceRepository extends JpaRepository<CompletedMaintenance, Long> {
}
