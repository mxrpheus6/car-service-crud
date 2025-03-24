package com.mxrpheus.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mxrpheus.carservice.model.id.MaintenanceConsumableMaterialId;
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

import java.math.BigDecimal;

@Entity
@Table(name = "service_consumable_material")
@IdClass(MaintenanceConsumableMaterialId.class)
@Getter
@Setter
public class MaintenanceConsumableMaterial {

    @Id
    @Column(name = "service_id")
    private Long serviceId;

    @Id
    @Column(name = "consumable_material_id")
    private Long consumableMaterialId;

    @ManyToOne
    @MapsId("serviceId")
    @JsonIgnore
    @JoinColumn(name = "service_id", nullable = false, insertable = false, updatable = false)
    private Maintenance service;

    @ManyToOne
    @MapsId("consumableMaterialId")
    @JsonIgnore
    @JoinColumn(name = "consumable_material_id", nullable = false, insertable = false, updatable = false)
    private ConsumableMaterial consumableMaterial;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
}