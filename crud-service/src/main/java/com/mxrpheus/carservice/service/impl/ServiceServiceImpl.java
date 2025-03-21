package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.ServiceDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.ServiceMapper;
import com.mxrpheus.carservice.model.ServiceEntity;
import com.mxrpheus.carservice.repository.ServiceRepository;
import com.mxrpheus.carservice.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    @Override
    public List<ServiceDTO> getAllServices() {
        return serviceMapper.toDtoList(serviceRepository.findAll());
    }

    @Override
    public ServiceDTO getServiceById(Long id) {
        return serviceMapper.toDto(serviceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + id + " not found")));
    }

    @Override
    public ServiceDTO createService(ServiceDTO serviceDTO) {
        serviceDTO.setId(null);
        ServiceEntity serviceEntity = serviceMapper.toEntity(serviceDTO);
        return serviceMapper.toDto(serviceRepository.save(serviceEntity));
    }

    @Override
    public ServiceDTO updateService(Long id, ServiceDTO serviceDTO) {
        ServiceEntity serviceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + id + " not found"));

        serviceDTO.setId(null);
        serviceMapper.updateService(serviceDTO, serviceEntity);

        return serviceMapper.toDto(serviceRepository.save(serviceEntity));
    }

    @Override
    public void deleteServiceById(Long id) {
        ServiceEntity serviceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Service with id=" + id + " not found"));

        serviceRepository.delete(serviceEntity);
    }

}
