package com.hit.week9.domain.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9].{6,}")
    String username;

    @NotNull
    @Pattern(regexp = "^(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{6,}$")
    String password;
}
