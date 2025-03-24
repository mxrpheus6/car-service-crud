package com.mxrpheus.carservice.model.id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class MaintenanceEmployeeId {
    private static final long serialVersionUID = 1L;

    private Long serviceId;
    private Long employeeId;
}
