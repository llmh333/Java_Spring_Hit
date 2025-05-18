package com.hit.week9.domain.mapper;

import com.hit.week9.domain.dto.request.CreateUserRequest;
import com.hit.week9.domain.dto.response.UserResponseDTO;
import com.hit.week9.domain.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toUserResponseDTO(User user);
    User toUSer(CreateUserRequest createUserRequest);
}
