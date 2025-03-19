package com.mxrpheus.carservice.service.impl;

import com.mxrpheus.carservice.dto.PositionDTO;
import com.mxrpheus.carservice.exception.NoSuchEntityException;
import com.mxrpheus.carservice.mapper.PositionMapper;
import com.mxrpheus.carservice.model.Position;
import com.mxrpheus.carservice.repository.PositionRepository;
import com.mxrpheus.carservice.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    @Override
    public List<PositionDTO> getAllPositions() {
        return positionMapper.toDtoList(positionRepository.findAll());
    }

    @Override
    public PositionDTO getPositionById(Long id) {
        return positionMapper.toDto(positionRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Position with id=" + id + " not found")));
    }

    @Override
    public PositionDTO createPosition(PositionDTO positionDTO) {
        positionDTO.setId(null);
        Position position = positionMapper.toEntity(positionDTO);
        return positionMapper.toDto(positionRepository.save(position));
    }

    @Override
    public PositionDTO updatePosition(Long id, PositionDTO positionDTO) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Position with id=" + id + " not found"));

        positionDTO.setId(null);
        positionMapper.updatePosition(positionDTO, position);

        return positionMapper.toDto(positionRepository.save(position));
    }

    @Override
    public void deletePositionById(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Position with id=" + id + " not found"));

        positionRepository.delete(position);
    }
}
