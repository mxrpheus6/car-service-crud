package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.WorkAreaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAreaTypeRepository extends JpaRepository<WorkAreaType, Long> {
}
