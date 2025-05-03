package com.hit.week8.domain.service.impl;

import com.hit.week8.mapper.PositionMapper;
import com.hit.week8.constant.ErrorCode;
import com.hit.week8.domain.dto.repsonse.PositionResponseDTO;
import com.hit.week8.domain.dto.request.CreatePositionRequest;
import com.hit.week8.domain.dto.request.UpdatePositionRequest;
import com.hit.week8.domain.entity.Position;
import com.hit.week8.domain.exception.DuplicateException;
import com.hit.week8.domain.exception.NotFoundException;
import com.hit.week8.domain.repository.PositionRepository;
import com.hit.week8.domain.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    @Override
    public List<PositionResponseDTO> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        List<PositionResponseDTO> positionResponseDTOS = new ArrayList<>();
        for (Position position : positions) {
            positionResponseDTOS.add(positionMapper.toPositionResponseDTO(position));
        }
        return positionResponseDTOS;
    }

    @Override
    public PositionResponseDTO addPosition(CreatePositionRequest createPositionRequest) {

        if (positionRepository.existsByTitle(createPositionRequest.getTitle())) {
            throw new DuplicateException(ErrorCode.POSITION_TITLE_EXIST);
        }
        Position position = positionMapper.toPosition(createPositionRequest);
        return positionMapper.toPositionResponseDTO(positionRepository.save(position));
    }

    @Override
    public PositionResponseDTO updatePosition(Long positionID, UpdatePositionRequest updatePositionRequest) {
        Position position = positionRepository.findById(positionID).orElseThrow(() -> new NotFoundException(ErrorCode.POSITION_NOT_FOUND));
        if (updatePositionRequest.getTitle() != null) {
            position.setTitle(updatePositionRequest.getTitle());
        }
        if (updatePositionRequest.getDescription() != null) {
            position.setDescription(updatePositionRequest.getDescription());
        }
        return positionMapper.toPositionResponseDTO(positionRepository.save(position));
    }

    @Override
    public void deletePosition(Long positionID) {
        Position position = positionRepository.findById(positionID).orElseThrow(() -> new NotFoundException(ErrorCode.POSITION_NOT_FOUND));
        positionRepository.delete(position);
    }
}
