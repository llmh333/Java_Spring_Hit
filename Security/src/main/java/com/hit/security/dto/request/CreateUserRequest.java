package com.hit.security.domain.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class CreateUserRequest {

    @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$", message = "Username must be only letter and number, no special characters")
    String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be at least one uppercase, special character and at least 6 characters")
    String password;

    String email;
    Date dob;
}
