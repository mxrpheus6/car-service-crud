package com.mxrpheus.carservice.dto;

import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompletedMaintenanceEmployeeDTO {
    @NotNull(message = "Completed service ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long completedServiceId;

    @NotNull(message = "Employee ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long employeeId;
}
