package com.hit.week8.domain.service;

import com.hit.week8.domain.dto.repsonse.EmployeeResponseDTO;
import com.hit.week8.domain.dto.request.CreateEmployeeRequest;
import com.hit.week8.domain.dto.request.CreateEmployeeSearchRequest;
import com.hit.week8.domain.dto.request.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeResponseDTO> getAllEmployees();

    public List<EmployeeResponseDTO> searchFlexibleEmployees(String fullName, Long positionID, Long departmentID);

    public EmployeeResponseDTO addEmployee(CreateEmployeeRequest createEmployeeRequest);

    public EmployeeResponseDTO updateEmployee(Long employeeID, UpdateEmployeeRequest updateEmployeeRequest);

    public void deleteEmployee(Long employeeID);



}
