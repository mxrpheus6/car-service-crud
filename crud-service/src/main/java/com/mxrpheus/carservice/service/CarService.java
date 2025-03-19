package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();
    CarDTO getCarById(Long id);
    CarDTO createCar(CarDTO carDTO);
    CarDTO updateCar(Long id, CarDTO carDTO);
    void deleteCarById(Long id);
}
