package com.hit.week9.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationResponseDTO {

    String id;
    String username;
    boolean authenticated;
    String token;
}
