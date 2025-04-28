package com.user.service;

import java.util.List;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRegistrationRequest);
    UserResponse getUserById(String id);
    List<UserResponse> getAllUsers();
    void deleteUserById(String id);
}
