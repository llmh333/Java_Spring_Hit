package com.hit.week8.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class CreateEmployeeSearchRequest {
    String fullName;
    Long departmentID;
    Long positionID;
}
