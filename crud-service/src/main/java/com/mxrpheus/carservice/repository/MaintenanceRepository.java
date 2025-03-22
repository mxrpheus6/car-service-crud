package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
