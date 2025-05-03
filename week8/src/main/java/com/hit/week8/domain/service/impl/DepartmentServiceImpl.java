package com.hit.week8.domain.service.impl;

import com.hit.week8.Mapper.DepartmentMapper;
import com.hit.week8.constant.ErrorCode;
import com.hit.week8.domain.dto.repsonse.DepartmentResponseDTO;
import com.hit.week8.domain.dto.request.CreateDepartmentRequest;
import com.hit.week8.domain.dto.request.UpdateDepartmentRequest;
import com.hit.week8.domain.entity.Department;
import com.hit.week8.domain.exception.DuplicateException;
import com.hit.week8.domain.exception.NotFoundException;
import com.hit.week8.domain.repository.DepartmentRepository;
import com.hit.week8.domain.service.DepartmentService;
import com.hit.week8.response.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;


    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        List<Department> departments =  departmentRepository.findAll();
        List<DepartmentResponseDTO> departmentResponseDTOS = new ArrayList<>();
        for (Department department : departments) {
            departmentResponseDTOS.add(departmentMapper.toDepartmentResponseDTO(department));
        }
        return departmentResponseDTOS;
    }

    @Override
    public DepartmentResponseDTO addDepartment(CreateDepartmentRequest createDepartmentRequest) {
        if (departmentRepository.existsByName(createDepartmentRequest.getName())) {
            throw new DuplicateException(ErrorCode.DEPARTMENT_NAME_EXIST);
        }
        Department department = departmentMapper.toDepartment(createDepartmentRequest);
        return departmentMapper.toDepartmentResponseDTO(departmentRepository.save(department));

    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long departmentID, UpdateDepartmentRequest updateDepartmentRequest) {
        Department department = departmentRepository.findById(departmentID).orElseThrow(() -> new NotFoundException(ErrorCode.DEPARTMENT_NOT_FOUND));
        if (updateDepartmentRequest.getName() != null) {
            department.setName(updateDepartmentRequest.getName());
        }
        if (updateDepartmentRequest.getDescription() != null) {
            department.setDescription(updateDepartmentRequest.getDescription());
        }
        return departmentMapper.toDepartmentResponseDTO(departmentRepository.save(department));
    }

    @Override
    public void deleteDepartment(Long departmentID) {
        departmentRepository.findById(departmentID).orElseThrow(() -> new NotFoundException(ErrorCode.DEPARTMENT_NOT_FOUND));
        departmentRepository.deleteById(departmentID);
    }
}
