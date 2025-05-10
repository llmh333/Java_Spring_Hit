package com.hit.example.domain.dto.request.author;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data

public class CreateAuthorRequest {

    @NotNull
    String name;

    @NotNull
    Date dob;

    String bio;
}
