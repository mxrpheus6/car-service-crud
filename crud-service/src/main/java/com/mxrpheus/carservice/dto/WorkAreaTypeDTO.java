package com.mxrpheus.carservice.dto;

import com.mxrpheus.carservice.dto.validation.ValidationGroups;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkAreaTypeDTO {
    private Long id;

    @NotNull(message = "Work area type name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Work area type name must be at most 50 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String name;
}
