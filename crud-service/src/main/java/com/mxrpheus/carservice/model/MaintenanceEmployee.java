package com.mxrpheus.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mxrpheus.carservice.model.id.MaintenanceEmployeeId;
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
@Table(name = "service_employee")
@IdClass(MaintenanceEmployeeId.class)
@Getter
@Setter
public class MaintenanceEmployee {

    @Id
    @Column(name = "service_id")
    private Long serviceId;

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @MapsId("serviceId")
    @JsonIgnore
    @JoinColumn(name = "service_id", nullable = false, insertable = false, updatable = false)
    private Maintenance service;

    @ManyToOne
    @MapsId("employeeId")
    @JsonIgnore
    @JoinColumn(name = "employee_id", nullable = false, insertable = false, updatable = false)
    private Employee employee;
}
