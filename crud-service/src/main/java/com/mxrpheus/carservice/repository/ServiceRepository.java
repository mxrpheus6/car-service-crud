package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
