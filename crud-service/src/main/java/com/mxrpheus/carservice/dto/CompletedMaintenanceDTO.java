package com.mxrpheus.carservice.dto;

import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompletedMaintenanceDTO {
    private Long id;

    private LocalDate completedAt;

    @NotNull(message = "Status cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Status must be at most 50 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String status;

    @NotNull(message = "Work order ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long workOrderId;

    @NotNull(message = "Work area ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long workAreaId;

    @NotNull(message = "Service ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long serviceId;
}
