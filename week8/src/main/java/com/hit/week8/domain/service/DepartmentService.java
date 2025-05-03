package com.hit.week8.domain.service;

import com.hit.week8.domain.dto.repsonse.DepartmentResponseDTO;
import com.hit.week8.domain.dto.request.CreateDepartmentRequest;
import com.hit.week8.domain.dto.request.UpdateDepartmentRequest;
import com.hit.week8.domain.entity.Department;

import java.util.List;

public interface DepartmentService {

    public List<DepartmentResponseDTO> getAllDepartments();

    public DepartmentResponseDTO addDepartment(CreateDepartmentRequest createDepartmentRequest);

    public DepartmentResponseDTO updateDepartment(Long departmentID, UpdateDepartmentRequest updateDepartmentRequest);

    public void deleteDepartment(Long departmentID);
}
