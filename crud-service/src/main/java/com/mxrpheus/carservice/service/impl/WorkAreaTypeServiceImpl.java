package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.WorkAreaTypeDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.WorkAreaTypeMapper;
import com.mxrpheus.carservice.model.WorkAreaType;
import com.mxrpheus.carservice.repository.WorkAreaTypeRepository;
import com.mxrpheus.carservice.service.WorkAreaTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkAreaTypeServiceImpl implements WorkAreaTypeService {

    private final WorkAreaTypeRepository workAreaTypeRepository;
    private final WorkAreaTypeMapper workAreaTypeMapper;

    @Override
    public List<WorkAreaTypeDTO> getAllWorkAreaTypes() {
        return workAreaTypeMapper.toDtoList(workAreaTypeRepository.findAll());
    }

    @Override
    public WorkAreaTypeDTO getWorkAreaTypeById(Long id) {
        return workAreaTypeMapper.toDto(workAreaTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work area type with id=" + id + " not found")));
    }

    @Override
    public WorkAreaTypeDTO createWorkAreaType(WorkAreaTypeDTO workAreaTypeDTO) {
        workAreaTypeDTO.setId(null);
        WorkAreaType workAreaType = workAreaTypeMapper.toEntity(workAreaTypeDTO);
        return workAreaTypeMapper.toDto(workAreaTypeRepository.save(workAreaType));
    }

    @Override
    public WorkAreaTypeDTO updateWorkAreaType(Long id, WorkAreaTypeDTO workAreaTypeDTO) {
        WorkAreaType workAreaType = workAreaTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work area type with id=" + id + " not found"));

        workAreaTypeDTO.setId(null);
        workAreaTypeMapper.updateWorkAreaType(workAreaTypeDTO, workAreaType);

        return workAreaTypeMapper.toDto(workAreaTypeRepository.save(workAreaType));
    }

    @Override
    public void deleteWorkAreaTypeById(Long id) {
        WorkAreaType workAreaType = workAreaTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work area type with id=" + id + " not found"));

        workAreaTypeRepository.delete(workAreaType);
    }
}
