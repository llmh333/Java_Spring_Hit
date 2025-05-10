package com.hit.example.domain.dto.request.author;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateAuthorRequest {
    String name;
    Date dob;
    String bio;
}
