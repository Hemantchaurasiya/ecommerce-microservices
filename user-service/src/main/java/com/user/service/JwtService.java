package com.user.service;

import com.user.entity.User;

public interface JwtService {
    String generateToken(User user);
    String extractUsername(String token);
    // boolean validateToken(String token, UserDetails userDetails);
}
