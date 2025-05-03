package com.hit.week8.mapper;

import com.hit.week8.domain.dto.repsonse.EmployeeResponseDTO;
import com.hit.week8.domain.dto.request.CreateEmployeeRequest;
import com.hit.week8.domain.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeResponseDTO toEmployeeResponseDTO(Employee employee);

    Employee toEmployee(CreateEmployeeRequest createEmployeeRequest);
}
