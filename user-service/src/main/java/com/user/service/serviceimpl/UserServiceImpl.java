package com.user.service.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.entity.User;
import com.user.exceptions.UserNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import com.user.utils.Utils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = Utils.toUserEntity(userRequest);
        User savedUser = userRepository.save(user);
        return Utils.toUserResponse(savedUser);
    }

    @Override
    public UserResponse getUserById(String id) {
        User user = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return Utils.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> Utils.toUserResponse(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(String id) {
        User user = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        
        userRepository.delete(user);
    }

}
