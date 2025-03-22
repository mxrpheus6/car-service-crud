package com.mxrpheus.carservice.dto;

import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class WorkOrderDTO {
    private Long id;
    private String publicId;

    @NotNull(message = "Creation time cannot be null", groups = ValidationGroups.OnCreate.class)
    private LocalDate createdAt;
    private LocalDate completedAt;

    @Size(max = 255, message = "Comment must be at most 255 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String comment;

    @Digits(integer = 10, fraction = 2, message = "Total cost must have at most 10 digits before the decimal point and 2 digits after")
    private BigDecimal totalCost;

    @NotNull(message = "Car ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long carId;
}
