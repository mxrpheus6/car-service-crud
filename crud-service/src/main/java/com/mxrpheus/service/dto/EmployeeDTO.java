package com.mxrpheus.service.dto;

import com.mxrpheus.service.dto.validation.ValidationGroups;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;

    @NotNull(message = "First name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 25, message = "First name must be at most 25 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String firstName;

    @NotNull(message = "Last name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 25, message = "Last name must be at most 25 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String lastName;

    @NotNull(message = "Middle name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 25, message = "Middle name must be at most 25 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String middleName;

    @NotNull(message = "Sex cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(min = 1, max = 1, message = "Sex name must be 1 character",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String sex;

    @NotNull(message = "Date of birth cannot be null", groups = ValidationGroups.OnCreate.class)
    @Past(message = "Date of birth must be in the past",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private LocalDate dateOfBirth;

    @NotNull(message = "Address cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 25, message = "Address must be at most 255 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String address;

    @NotNull(message = "Phone number cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 25, message = "Phone number must be at most 20 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String phoneNumber;

    @NotNull(message = "Medical certificate expiry date cannot be null", groups = ValidationGroups.OnCreate.class)
    private LocalDate medicalCertificateExpiry;

    @NotNull(message = "Salary cannot be null", groups = ValidationGroups.OnCreate.class)
    @Digits(integer = 10, fraction = 2, message = "Salary must have at most 10 digits before the decimal point and 2 digits after")
    private BigDecimal salary;

    @NotNull(message = "Position ID cannot be null", groups = ValidationGroups.OnCreate.class)
    private Long positionId;
}
