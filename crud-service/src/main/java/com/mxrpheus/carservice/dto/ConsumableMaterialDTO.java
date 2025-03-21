package com.mxrpheus.carservice.dto;

import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ConsumableMaterialDTO {
    private Long id;

    @NotNull(message = "Consumable material name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Consumable material name must be at most 50 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String name;

    @NotNull(message = "Consumable material unit cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 20, message = "Consumable material unit must be at most 20 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String unit;

    @NotNull(message = "Consumable material unit cost cannot be null", groups = ValidationGroups.OnCreate.class)
    @Digits(integer = 10, fraction = 2, message = "Consumable material unit cost must have at most 10 digits before the decimal point and 2 digits after",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private BigDecimal unitCost;

    @NotNull(message = "Consumable material current stock cannot be null", groups = ValidationGroups.OnCreate.class)
    @Digits(integer = 10, fraction = 2, message = "Consumable material current stock must have at most 10 digits before the decimal point and 2 digits after",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private BigDecimal currentStock;
}
