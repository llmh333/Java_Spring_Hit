package com.hit.week8.mapper;

import com.hit.week8.domain.dto.repsonse.DepartmentResponseDTO;
import com.hit.week8.domain.dto.request.CreateDepartmentRequest;
import com.hit.week8.domain.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentResponseDTO toDepartmentResponseDTO(Department department);
    Department toDepartment(CreateDepartmentRequest createDepartmentRequest);
}
