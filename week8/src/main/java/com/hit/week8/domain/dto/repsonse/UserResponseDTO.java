package com.hit.week8.domain.dto.repsonse;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    String id;
    String username;
    String email;
    LocalDateTime createdAt;
}
