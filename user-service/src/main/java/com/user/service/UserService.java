package com.user.service;

import java.util.List;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequestDTO);
    UserResponse getUserById(String id);
    List<UserResponse> getAllUsers();
    void deleteUserById(String id);
}
