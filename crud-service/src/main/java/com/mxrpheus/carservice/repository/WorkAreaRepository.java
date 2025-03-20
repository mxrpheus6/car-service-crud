package com.mxrpheus.carservice.repository;

import com.mxrpheus.carservice.model.WorkArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAreaRepository extends JpaRepository<WorkArea, Long> {
}
