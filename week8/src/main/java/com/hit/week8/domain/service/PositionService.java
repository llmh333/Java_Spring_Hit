package com.hit.week8.domain.service;

import com.hit.week8.domain.dto.repsonse.PositionResponseDTO;
import com.hit.week8.domain.dto.request.CreatePositionRequest;
import com.hit.week8.domain.dto.request.UpdatePositionRequest;

import java.util.List;

public interface PositionService {

    public List<PositionResponseDTO> getAllPositions();

    public PositionResponseDTO addPosition(CreatePositionRequest createPositionRequest);

    public PositionResponseDTO updatePosition(Long positionID, UpdatePositionRequest updatePositionRequest);

    public void deletePosition(Long positionID);
}
