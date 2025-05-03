package com.hit.week8.controller;

import com.hit.week8.domain.dto.repsonse.EmployeeResponseDTO;
import com.hit.week8.domain.dto.request.CreateEmployeeRequest;
import com.hit.week8.domain.dto.request.UpdateEmployeeRequest;
import com.hit.week8.domain.service.EmployeeService;
import com.hit.week8.response.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.addEmployee(createEmployeeRequest);
        return ApiResponseUtil.success(HttpStatus.CREATED, employeeResponseDTO);
    }

    @PutMapping("/update/{employeeID}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long employeeID, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.updateEmployee(employeeID, updateEmployeeRequest);
        return ApiResponseUtil.success(HttpStatus.OK, employeeResponseDTO);
    }

    @DeleteMapping("/delete/{employeeID}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeID) {
        employeeService.deleteEmployee(employeeID);
        return ApiResponseUtil.success(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchEmployee(@RequestParam(value = "fullName",required = false) String fullName, @RequestParam(value = "positionID", required = false) Long positionID, @RequestParam(value = "departmentID", required = false) Long departmentID) {
        System.out.println(positionID);
        List<EmployeeResponseDTO> employeeResponseDTOList = employeeService.searchFlexibleEmployees(fullName, positionID, departmentID);
        return ApiResponseUtil.success(HttpStatus.OK, employeeResponseDTOList);
    }
}
