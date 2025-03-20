package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.WorkAreaTypeDTO;

import java.util.List;

public interface WorkAreaTypeService {
    List<WorkAreaTypeDTO> getAllWorkAreaTypes();
    WorkAreaTypeDTO getWorkAreaTypeById(Long id);
    WorkAreaTypeDTO createWorkAreaType(WorkAreaTypeDTO workAreaTypeDTO);
    WorkAreaTypeDTO updateWorkAreaType(Long id, WorkAreaTypeDTO workAreaTypeDTO);
    void deleteWorkAreaTypeById(Long id);
}
