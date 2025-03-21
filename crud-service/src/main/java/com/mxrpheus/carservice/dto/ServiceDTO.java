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
public class ServiceDTO {
    private Long id;

    @NotNull(message = "Service name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Service name must be at most 50 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String name;

    @Size(max = 255, message = "Service description must be at most 255 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String description;

    @NotNull(message = "Service price cannot be null", groups = ValidationGroups.OnCreate.class)
    @Digits(integer = 10, fraction = 2, message = "Service price must have at most 10 digits before the decimal point and 2 digits after",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private BigDecimal price;

    @Size(max = 50, message = "Service warranty period must be at most 50 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String warrantyPeriod;
}
