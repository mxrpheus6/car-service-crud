package com.mxrpheus.carservice.dto;

import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WorkAreaDTO {
    private Long id;

    @NotNull(message = "Work area name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Work area name must be at most 50 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String name;

    @NotNull(message = "Work area status cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Work area status must be at most 50 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String status;

    @PastOrPresent(message = "Date of birth must be in the past or present",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private LocalDate lastServiceDate;

    @NotNull(message = "Work area type ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long workAreaTypeId;
}
