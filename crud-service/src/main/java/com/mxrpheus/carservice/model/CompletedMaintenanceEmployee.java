package com.mxrpheus.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mxrpheus.carservice.model.id.CompletedMaintenanceEmployeeId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "completed_service_employee")
@IdClass(CompletedMaintenanceEmployeeId.class)
@Getter
@Setter
public class CompletedMaintenanceEmployee {
    @Id
    @Column(name = "completed_service_id")
    private Long completedServiceId;

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @MapsId("completedServiceId")
    @JsonIgnore
    @JoinColumn(name = "completed_service_id", nullable = false, insertable = false, updatable = false)
    private CompletedMaintenance completedService;

    @ManyToOne
    @MapsId("employeeId")
    @JsonIgnore
    @JoinColumn(name = "employee_id", nullable = false, insertable = false, updatable = false)
    private Employee employee;
}
