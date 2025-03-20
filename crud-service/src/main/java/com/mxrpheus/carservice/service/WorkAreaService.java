package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.WorkAreaDTO;

import java.util.List;

public interface WorkAreaService {
    List<WorkAreaDTO> getAllWorkAreas();
    WorkAreaDTO getWorkAreaById(Long id);
    WorkAreaDTO createWorkArea(WorkAreaDTO workAreaDTO);
    WorkAreaDTO updateWorkArea(Long id, WorkAreaDTO workAreaDTO);
    void deleteWorkAreaById(Long id);
}
