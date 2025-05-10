package com.hit.week8.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CreateEmployeeRequest {

    @NotBlank
    String fullName;

    @NotNull
    BigDecimal salary;

    @NotNull
    Date dateOfBirth;

    @NotNull
    Date hireDate;

    @NotNull
    Long departmentID;

    @NotNull
    Long positionID;

    @NotNull
    String userID;
}
