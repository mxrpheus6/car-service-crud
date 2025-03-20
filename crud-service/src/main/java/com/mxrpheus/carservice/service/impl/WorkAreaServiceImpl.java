package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.WorkAreaDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.WorkAreaMapper;
import com.mxrpheus.carservice.model.WorkArea;
import com.mxrpheus.carservice.model.WorkAreaType;
import com.mxrpheus.carservice.repository.WorkAreaRepository;
import com.mxrpheus.carservice.repository.WorkAreaTypeRepository;
import com.mxrpheus.carservice.service.WorkAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkAreaServiceImpl implements WorkAreaService {

    private final WorkAreaTypeRepository workAreaTypeRepository;
    private final WorkAreaRepository workAreaRepository;
    private final WorkAreaMapper workAreaMapper;


    @Override
    public List<WorkAreaDTO> getAllWorkAreas() {
        return workAreaMapper.toDtoList(workAreaRepository.findAll());
    }

    @Override
    public WorkAreaDTO getWorkAreaById(Long id) {
        return workAreaMapper.toDto(workAreaRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work area with id=" + id + " not found")));
    }

    @Override
    public WorkAreaDTO createWorkArea(WorkAreaDTO workAreaDTO) {
        WorkAreaType workAreaType = workAreaTypeRepository.findById(workAreaDTO.getWorkAreaTypeId())
                .orElseThrow(() -> new NoSuchEntityException("Work area type with id=" + workAreaDTO.getWorkAreaTypeId() + " not found"));

        workAreaDTO.setId(null);
        WorkArea workArea = workAreaMapper.toEntity(workAreaDTO);
        workArea.setWorkAreaType(workAreaType);

        return workAreaMapper.toDto(workAreaRepository.save(workArea));
    }

    @Override
    public WorkAreaDTO updateWorkArea(Long id, WorkAreaDTO workAreaDTO) {
        WorkArea workArea = workAreaRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work area with id=" + id + " not found"));

        workAreaDTO.setId(null);
        workAreaMapper.updateWorkArea(workAreaDTO, workArea);

        if (workAreaDTO.getWorkAreaTypeId() != null) {
            WorkAreaType workAreaType = workAreaTypeRepository.findById(workAreaDTO.getWorkAreaTypeId())
                    .orElseThrow(() -> new NoSuchEntityException("Work area type with id=" + workAreaDTO.getWorkAreaTypeId() + " not found"));
            workArea.setWorkAreaType(workAreaType);
        }

        return workAreaMapper.toDto(workAreaRepository.save(workArea));
    }

    @Override
    public void deleteWorkAreaById(Long id) {
        WorkArea workArea = workAreaRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Work area with id=" + id + " not found"));

        workAreaRepository.delete(workArea);
    }
}
