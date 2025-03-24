package com.mxrpheus.carservice.dto;

import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MaintenanceConsumableMaterialDTO {

    @NotNull(message = "Service ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long serviceId;

    @NotNull(message = "Consumable ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long consumableMaterialId;

    @NotNull(message = "Amount cannot be null", groups = ValidationGroups.OnCreate.class)
    @Digits(integer = 10, fraction = 2, message = "Amount must have at most 10 digits before " +
            "the decimal point and 2 digits after", groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private BigDecimal amount;
}
