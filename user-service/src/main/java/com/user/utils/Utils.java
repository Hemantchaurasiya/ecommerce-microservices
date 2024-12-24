package com.user.utils;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.entity.User;

public class Utils {
    // Convert UserRequestDTO to User entity
    public static User toUserEntity(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone(userRequest.getPhone());
        return user;
    }

    // Convert User entity to UserResponseDTO
    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
            user.getId().toString(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPhone()
        );
    }
}
