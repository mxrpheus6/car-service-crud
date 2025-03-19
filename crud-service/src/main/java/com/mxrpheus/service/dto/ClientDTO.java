package com.mxrpheus.service.dto;

import com.mxrpheus.service.dto.validation.ValidationGroups;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientDTO {

    private Long id;

    @NotNull(message = "First name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 25, message = "First name must be at most 25 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String firstName;

    @NotNull(message = "Last name cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 25, message = "Last name must be at most 25 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String lastName;

    @Size(max = 25, message = "Middle name must be at most 25 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String middleName;

    @NotNull(message = "Phone number cannot be null", groups = ValidationGroups.OnCreate.class)
    @Size(max = 20, message = "Phone number must be at most 20 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String phoneNumber;

    @Email(message = "Invalid email format",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    @Size(max = 255, message = "Email must be at most 255 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String email;

    @Size(max = 255, message = "Address must be at most 255 characters long",
            groups = { ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class })
    private String address;

    private LocalDate registrationDate;
}
