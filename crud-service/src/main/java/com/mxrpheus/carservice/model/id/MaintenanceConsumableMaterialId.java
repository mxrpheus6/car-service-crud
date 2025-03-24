package com.mxrpheus.carservice.model.id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class MaintenanceConsumableMaterialId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long serviceId;
    private Long consumableMaterialId;
}
