package com.hit.week8.mapper;

import com.hit.week8.domain.dto.repsonse.PositionResponseDTO;
import com.hit.week8.domain.dto.request.CreatePositionRequest;
import com.hit.week8.domain.entity.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    PositionResponseDTO toPositionResponseDTO(Position position);

    Position toPosition(CreatePositionRequest createPositionRequest);
}
