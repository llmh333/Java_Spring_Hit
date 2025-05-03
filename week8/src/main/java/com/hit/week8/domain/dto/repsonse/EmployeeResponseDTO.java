package com.hit.week8.domain.dto.repsonse;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Data
public class EmployeeResponseDTO {
    Long id;
    UserResponseDTO user;
    DepartmentResponseDTO department;
    PositionResponseDTO position;
    String fullName;
    BigDecimal salary;
    Date hireDate;
    Date dateOfBirth;
}
