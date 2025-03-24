package com.mxrpheus.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mxrpheus.carservice.model.id.WorkAreaMaintenanceId;
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
@Table(name = "work_area_service")
@IdClass(WorkAreaMaintenanceId.class)
@Getter
@Setter
public class WorkAreaMaintenance {

    @Id
    @Column(name = "work_area_id")
    private Long workAreaId;

    @Id
    @Column(name = "service_id")
    private Long serviceId;

    @ManyToOne
    @MapsId("workAreaId")
    @JsonIgnore
    @JoinColumn(name = "work_area_id", nullable = false, insertable = false, updatable = false)
    private WorkArea workArea;

    @ManyToOne
    @MapsId("serviceId")
    @JsonIgnore
    @JoinColumn(name = "service_id", nullable = false, insertable = false, updatable = false)
    private Maintenance service;

}
