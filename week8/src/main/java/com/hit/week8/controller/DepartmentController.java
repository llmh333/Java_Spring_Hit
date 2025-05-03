package com.hit.week8.controller;

import com.hit.week8.domain.dto.repsonse.DepartmentResponseDTO;
import com.hit.week8.domain.dto.request.CreateDepartmentRequest;
import com.hit.week8.domain.dto.request.UpdateDepartmentRequest;
import com.hit.week8.domain.service.DepartmentService;
import com.hit.week8.response.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<DepartmentResponseDTO> departments = departmentService.getAllDepartments();
        return ApiResponseUtil.success(HttpStatus.OK, departments);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDepartment(@RequestBody @Valid CreateDepartmentRequest request) {
        DepartmentResponseDTO department = departmentService.addDepartment(request);
        return ApiResponseUtil.success(HttpStatus.CREATED, department);
    }

    @PutMapping("/update/{departmentID}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long departmentID, @RequestBody UpdateDepartmentRequest updateDepartmentRequest) {
        DepartmentResponseDTO departmentResponseDTO = departmentService.updateDepartment(departmentID, updateDepartmentRequest);
        return ApiResponseUtil.success(HttpStatus.OK, departmentResponseDTO);
    }

    @DeleteMapping("/delete/{departmentID}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentID) {
        departmentService.deleteDepartment(departmentID);
        return ApiResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}
