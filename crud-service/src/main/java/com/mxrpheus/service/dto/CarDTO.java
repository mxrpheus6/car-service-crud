package com.mxrpheus.service.dto;

import com.mxrpheus.service.dto.validation.ValidationGroups;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private Long id;

    @NotNull(message = "Plate number cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 20, message = "Plate number must be at most 20 characters long",
            groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    private String plateNumber;

    @NotNull(message = "Manufacturer cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Manufacturer must be at most 50 characters long",
            groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    private String manufacturer;

    @NotNull(message = "Model cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 50, message = "Model must be at most 50 characters long",
            groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    private String model;

    @NotNull(message = "Engine type cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 20, message = "Engine type must be at most 20 characters long",
            groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    private String engineType;

    private Integer manufactureYear;

    @NotNull(message = "Client ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long clientId;

}