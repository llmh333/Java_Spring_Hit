package com.hit.week9.domain.dto.request;

import com.hit.week9.constant.ErrorMessage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AuthenticationRequest {

    @NotNull(message = ErrorMessage.User.USERNAME_ERROR_VALIDATION)
    @Pattern(regexp = "^[a-zA-Z0-9].{6,}", message = ErrorMessage.User.USERNAME_ERROR_VALIDATION)
    String username;

    @NotNull(message = ErrorMessage.User.PASSWORD_ERROR_VALIDATION)
    @Pattern(regexp = "^(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{6,}$", message = ErrorMessage.User.PASSWORD_ERROR_VALIDATION)
    String password;
}
