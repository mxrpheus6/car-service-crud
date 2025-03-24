package com.mxrpheus.carservice.model.id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class WorkAreaMaintenanceId {
    private static final long serialVersionUID = 1L;

    private Long workAreaId;
    private Long serviceId;
}
