package com.mxrpheus.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private Long id;
    private String plateNumber;
    private String manufacturer;
    private String model;
    private String engineType;
    private Integer manufactureYear;
    private Long clientId;
}
