package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.MaintenanceConsumableMaterial;
import com.mxrpheus.carservice.model.id.MaintenanceConsumableMaterialId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceConsumableMaterialRepository extends JpaRepository<MaintenanceConsumableMaterial,
                                                                               MaintenanceConsumableMaterialId> {
}
