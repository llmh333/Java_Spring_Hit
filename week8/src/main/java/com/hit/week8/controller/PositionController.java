package com.hit.week8.controller;

import com.hit.week8.domain.dto.repsonse.PositionResponseDTO;
import com.hit.week8.domain.dto.request.CreatePositionRequest;
import com.hit.week8.domain.dto.request.UpdatePositionRequest;
import com.hit.week8.domain.service.PositionService;
import com.hit.week8.response.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/position")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<PositionResponseDTO> positionResponseDTOS = positionService.getAllPositions();
        return ApiResponseUtil.success(positionResponseDTOS);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPosition(@RequestBody CreatePositionRequest createPositionRequest) {
        PositionResponseDTO positionResponseDTO = positionService.addPosition(createPositionRequest);
        return ApiResponseUtil.success(HttpStatus.CREATED, positionResponseDTO);
    }

    @PutMapping("/update/{positionID}")
    public ResponseEntity<?> updatePosition(@PathVariable Long positionID, @RequestBody UpdatePositionRequest updatePositionRequest) {
        PositionResponseDTO positionResponseDTO = positionService.updatePosition(positionID, updatePositionRequest);
        return ApiResponseUtil.success(HttpStatus.OK, positionResponseDTO);
    }

    @DeleteMapping("/delete/{positionID}")
    public ResponseEntity<?> deletePosition(@PathVariable Long positionID) {
        positionService.deletePosition(positionID);
        return ApiResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}
