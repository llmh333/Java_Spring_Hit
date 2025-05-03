package com.hit.week8.domain.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UpdateEmployeeRequest {
    String fullName;
    Long departmentID;
    Long positionID;
    String userId;
    Date hireDate;
    Date dateOfBirth;
    BigDecimal salary;
}
