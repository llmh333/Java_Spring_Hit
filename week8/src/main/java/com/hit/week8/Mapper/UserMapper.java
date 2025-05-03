package com.hit.week8.Mapper;

import com.hit.week8.domain.dto.repsonse.UserResponseDTO;
import com.hit.week8.domain.dto.request.CreateUserRequest;
import com.hit.week8.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(CreateUserRequest createUserRequest);
    UserResponseDTO toUserResponseDTO(User user);
}
