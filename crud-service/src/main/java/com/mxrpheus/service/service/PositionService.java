package com.mxrpheus.service.service;

import com.mxrpheus.service.dto.PositionDTO;

import java.util.List;

public interface PositionService {
    List<PositionDTO> getAllPositions();
    PositionDTO getPositionById(Long id);
    PositionDTO createPosition(PositionDTO positionDTO);
    PositionDTO updatePosition(Long id, PositionDTO positionDTO);
    void deletePositionById(Long id);
}
