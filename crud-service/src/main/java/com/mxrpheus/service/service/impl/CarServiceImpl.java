package com.mxrpheus.service.service.impl;

import com.mxrpheus.service.dto.CarDTO;
import com.mxrpheus.service.exception.NoSuchEntityException;
import com.mxrpheus.service.mapper.CarMapper;
import com.mxrpheus.service.model.Car;
import com.mxrpheus.service.model.Client;
import com.mxrpheus.service.repository.CarRepository;
import com.mxrpheus.service.repository.ClientRepository;
import com.mxrpheus.service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarDTO> getAllCars() {
        return carMapper.toDtoList(carRepository.findAll());
    }

    @Override
    public CarDTO getCarById(Long id) {
        return carMapper.toDto(carRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Car with id=" + id + " not found")));
    }

    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Client client = clientRepository.findById(carDTO.getClientId())
                .orElseThrow(() -> new NoSuchEntityException("Client with id=" + carDTO.getClientId() + " not found"));

        carDTO.setId(null);
        Car car = carMapper.toEntity(carDTO);
        car.setClient(client);

        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public CarDTO updateCar(Long id, CarDTO carDTO) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Car with id=" + id + " not found"));

        carDTO.setId(null);
        carMapper.updateCar(carDTO, car);

        if (carDTO.getClientId() != null) {
            Client client = clientRepository.findById(carDTO.getClientId())
                    .orElseThrow(() -> new NoSuchEntityException("Client with id=" + carDTO.getClientId() + " not found"));
            car.setClient(client);
        }

        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public void deleteCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Car with id=" + id + " not found"));

        carRepository.delete(car);
    }
}
