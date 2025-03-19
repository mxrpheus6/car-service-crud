package com.mxrpheus.carservice.service;

import com.mxrpheus.carservice.dto.PositionDTO;

import java.util.List;

public interface PositionService {
    List<PositionDTO> getAllPositions();
    PositionDTO getPositionById(Long id);
    PositionDTO createPosition(PositionDTO positionDTO);
    PositionDTO updatePosition(Long id, PositionDTO positionDTO);
    void deletePositionById(Long id);
}
